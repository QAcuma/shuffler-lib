package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.repository.StatisticRepository;

import java.util.List;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;
import static org.jooq.impl.DSL.when;
import static ru.acuma.shuffler.tables.GroupInfo.GROUP_INFO;
import static ru.acuma.shuffler.tables.Player.PLAYER;
import static ru.acuma.shuffler.tables.Rating.RATING;
import static ru.acuma.shuffler.tables.UserInfo.USER_INFO;

@Repository
@RequiredArgsConstructor
public class StatisticRepositoryImpl implements StatisticRepository {

    private final DSLContext dsl;

    @Override
    public List<WebPlayer> findAllByFilter(Filter filter) {
        return dsl.select(
                        PLAYER.ID,
                        concat(
                                when(USER_INFO.FIRST_NAME.isNotNull(), USER_INFO.FIRST_NAME).otherwise(""),
                                val(" "),
                                when(USER_INFO.LAST_NAME.isNotNull(), USER_INFO.LAST_NAME).otherwise("")
                        ),
                        RATING.SCORE
                )
                .from(PLAYER)
                .join(USER_INFO).on(PLAYER.USER_ID.eq(USER_INFO.TELEGRAM_ID))
                .join(RATING).on(RATING.PLAYER_ID.eq(PLAYER.ID))
                .join(GROUP_INFO).on(PLAYER.CHAT_ID.eq(GROUP_INFO.CHAT_ID))
                .where(GROUP_INFO.NAME.eq(filter.getChatName()))
                .and(RATING.DISCIPLINE.eq(filter.getDiscipline().name()))
                .fetchInto(WebPlayer.class);
    }
}

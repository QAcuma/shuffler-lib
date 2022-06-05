package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.Game;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.StatisticResult;
import ru.acuma.shufflerlib.repository.StatisticRepository;

import java.util.List;

import static org.jooq.impl.DSL.noCondition;
import static ru.acuma.shuffler.tables.GroupInfo.GROUP_INFO;
import static ru.acuma.shuffler.tables.Player.PLAYER;
import static ru.acuma.shuffler.tables.Rating.RATING;
import static ru.acuma.shuffler.tables.UserInfo.USER_INFO;

@Repository
@RequiredArgsConstructor
public class StatisticRepositoryImpl implements StatisticRepository {

    private final DSLContext dsl;

    @Override
    public List<StatisticResult> findAllByFilter(Filter filter) {
        return dsl.select(PLAYER.ID, USER_INFO.FIRST_NAME, RATING.SCORE)
                .from(PLAYER)
                .join(USER_INFO).on(PLAYER.USER_ID.eq(USER_INFO.TELEGRAM_ID))
                .join(RATING).on(RATING.PLAYER_ID.eq(PLAYER.ID))
                .join(GROUP_INFO).on(PLAYER.CHAT_ID.eq(GROUP_INFO.CHAT_ID))
                .where(GROUP_INFO.NAME.eq(filter.getChatName()))
                .and(RATING.DISCIPLINE.eq(filter.getDiscipline().name()))
                .and(condition(filter))
                .fetchInto(StatisticResult.class);
    }

    public Condition condition(Filter filter) {
        Condition result = noCondition();

//        if (filter.getChatId() != null)
//            result = result.and(BOOK.TITLE.like("%" + request.getParameter("title") + "%"));
//
//        if (request.getParameter("author") != null)
//            result = result.and(BOOK.AUTHOR_ID.in(
//                    selectOne().from(AUTHOR).where(
//                            AUTHOR.FIRST_NAME.like("%" + request.getParameter("author") + "%")
//                                    .or(AUTHOR.LAST_NAME .like("%" + request.getParameter("author") + "%"))
//                    )
//            ));

        return result;
    }
}

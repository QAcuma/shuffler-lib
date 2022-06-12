package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebCoordinate;
import ru.acuma.shufflerlib.model.web.entity.WebGraph;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.repository.StatisticRepository;
import ru.acuma.shufflerlib.repository.util.FilterUtil;

import java.sql.Timestamp;
import java.util.List;

import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.selectDistinct;
import static org.jooq.impl.DSL.val;
import static org.jooq.impl.DSL.when;
import static ru.acuma.shuffler.tables.Event.EVENT;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.GroupInfo.GROUP_INFO;
import static ru.acuma.shuffler.tables.Player.PLAYER;
import static ru.acuma.shuffler.tables.Rating.RATING;
import static ru.acuma.shuffler.tables.RatingHistory.RATING_HISTORY;
import static ru.acuma.shuffler.tables.Team.TEAM;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;
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

    @Override
    public List<WebGraph> buildGraphsByFilter(Filter filter) {
        return dsl.select(
                        PLAYER.ID,
                        multiset(
                                selectDistinct(
                                        GAME.FINISHED_AT,
                                        RATING_HISTORY.SCORE
                                )
                                        .from(RATING_HISTORY)
                                        .join(GAME).on(GAME.ID.eq(RATING_HISTORY.GAME_ID))
                                        .join(EVENT).on(EVENT.ID.eq(GAME.EVENT_ID))
                                        .join(TEAM).on(TEAM.GAME_ID.eq(GAME.ID))
                                        .join(TEAM_PLAYER).on(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                                        .where(RATING_HISTORY.PLAYER_ID.eq(PLAYER.ID))
                                        .and(EVENT.SEASON_ID.eq(filter.getSeasonId()))
                                        .and(EVENT.DISCIPLINE.eq(filter.getDiscipline().name()))
                                        .and(GAME.STATE.eq("FINISHED"))
                                        .orderBy(GAME.FINISHED_AT)
                        ).as("coordinates").convertFrom(r -> r.map(mapping(WebCoordinate::new)))
                )
                .from(PLAYER)
                .join(GROUP_INFO).on(GROUP_INFO.CHAT_ID.eq(PLAYER.CHAT_ID))
                .where(FilterUtil.requiredPlayerOrChatCondition(filter))
                .fetchInto(WebGraph.class);
    }

}

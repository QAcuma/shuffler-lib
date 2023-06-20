package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebCoordinate;
import ru.acuma.shufflerlib.model.web.entity.WebGraph;
import ru.acuma.shufflerlib.repository.StatisticRepository;
import ru.acuma.shufflerlib.repository.util.FilterUtil;

import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.selectDistinct;
import static ru.acuma.shuffler.tables.Event.EVENT;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.GroupInfo.GROUP_INFO;
import static ru.acuma.shuffler.tables.Player.PLAYER;
import static ru.acuma.shuffler.tables.RatingHistory.RATING_HISTORY;
import static ru.acuma.shuffler.tables.Team.TEAM;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;

@Repository
@RequiredArgsConstructor
public class StatisticRepositoryImpl implements StatisticRepository {

    private final DSLContext dsl;

    @Override
    public WebGraph buildGraphData(Filter filter) {
        return dsl.select(
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
                                        .and(FilterUtil.eventSeasonAndDisciplineCondition(filter))
                                        .and(GAME.STATUS.eq("FINISHED"))
                                        .orderBy(GAME.FINISHED_AT)
                        ).as("coordinates").convertFrom(r -> r.map(mapping(WebCoordinate::new)))
                )
                .from(PLAYER)
                .join(GROUP_INFO).on(GROUP_INFO.ID.eq(PLAYER.CHAT_ID))
                .where(FilterUtil.requiredPlayerCondition(filter))
                .fetchOneInto(WebGraph.class);
    }

}

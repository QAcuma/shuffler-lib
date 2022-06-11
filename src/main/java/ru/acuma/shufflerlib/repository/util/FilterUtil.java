package ru.acuma.shufflerlib.repository.util;

import org.jooq.Condition;
import ru.acuma.shufflerlib.exception.MissingRequireArgumentException;
import ru.acuma.shufflerlib.model.Filter;

import java.util.Optional;

import static org.jooq.impl.DSL.noCondition;
import static ru.acuma.shuffler.tables.Event.EVENT;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.GroupInfo.GROUP_INFO;
import static ru.acuma.shuffler.tables.RatingHistory.RATING_HISTORY;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;

public class FilterUtil {

    public static Condition chatOrPlayerAndSeasonDisciplineCondition(Filter filter) {
        Optional.of(filter.getSeasonId())
                .orElseThrow(() -> new MissingRequireArgumentException("seasonId"));
        Condition result = noCondition();
        if (filter.getChatName() != null) {
            result = result.and(GROUP_INFO.NAME.eq(filter.getChatName()));
        } else if (filter.getPlayerId() != null) {
            result = result.and(RATING_HISTORY.PLAYER_ID.eq(filter.getPlayerId()));
        } else {
            throw new MissingRequireArgumentException("chatName", "playerId");
        }

        result = result
                .and(EVENT.SEASON_ID.eq(filter.getSeasonId()))
                .and(EVENT.DISCIPLINE.eq(filter.getDiscipline().name()));


        return result;
    }

    public static Condition playerDisciplineSeasonGameStateCondition(Filter filter) {
        Condition result = noCondition();
        result = result
                .and(TEAM_PLAYER.PLAYER_ID.eq(filter.getPlayerId()))
                .and(EVENT.DISCIPLINE.eq(filter.getDiscipline().name()))
                .and(EVENT.SEASON_ID.eq(filter.getSeasonId()))
                .and(GAME.STATE.eq("FINISHED"));

        return result;
    }

}

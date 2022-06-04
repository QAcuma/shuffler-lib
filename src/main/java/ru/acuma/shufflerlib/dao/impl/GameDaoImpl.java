package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.Game;
import ru.acuma.shuffler.tables.records.GameRecord;
import ru.acuma.shufflerlib.dao.GameDao;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

import static ru.acuma.shuffler.tables.Event.EVENT;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.Team.TEAM;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;

@Repository
@RequiredArgsConstructor
public class GameDaoImpl implements GameDao {

    private final DSLContext dsl;

    @Override
    public long save(Game game) {
        GameRecord record = dsl.newRecord(GAME, game);
        record.store();
        return record.getId();
    }

    @Override
    public List<Game> findAllBySeasonId(Long seasonId, Long chatId, Discipline discipline) {
        return dsl.select(GAME.fields())
                .from(GAME)
                .join(EVENT).on(EVENT.ID.eq(GAME.EVENT_ID))
                .where(EVENT.SEASON_ID.eq(seasonId))
                .and(EVENT.CHAT_ID.eq(chatId))
                .and(EVENT.DISCIPLINE.eq(discipline.name()))
                .fetchInto(Game.class);
    }

    @Override
    public List<Game> findAllByEventId(Long eventId, Long chatId, Discipline discipline) {
        return dsl.select(GAME.fields())
                .from(GAME)
                .join(EVENT).on(EVENT.ID.eq(GAME.EVENT_ID))
                .where(GAME.EVENT_ID.eq(eventId))
                .and(EVENT.CHAT_ID.eq(chatId))
                .and(EVENT.DISCIPLINE.eq(discipline.name()))
                .fetchInto(Game.class);
    }

    @Override
    public List<Game> findAllByPlayerIdAndSeasonIds(Long playerId, List<Long> seasonIds, Long chatId, Discipline discipline) {
        return dsl.select(GAME.fields())
                .from(GAME)
                .join(EVENT).on(EVENT.ID.eq(GAME.EVENT_ID))
                .join(TEAM).on(TEAM.GAME_ID.eq(GAME.ID))
                .join(TEAM_PLAYER).on(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                .where(TEAM_PLAYER.PLAYER_ID.eq(playerId))
                .and(EVENT.CHAT_ID.eq(chatId))
                .and(EVENT.DISCIPLINE.eq(discipline.name()))
                .and(EVENT.SEASON_ID.in(seasonIds))
                .fetchInto(Game.class);
    }
}

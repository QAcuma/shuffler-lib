package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.GameDao;
import ru.acuma.shuffler.tables.daos.RatingDao;
import ru.acuma.shuffler.tables.pojos.Game;
import ru.acuma.shuffler.tables.records.GameRecord;
import ru.acuma.shufflerlib.repository.GameRepository;
import ru.acuma.shufflerlib.model.Discipline;

import javax.annotation.PostConstruct;
import java.util.List;

import static ru.acuma.shuffler.tables.Event.EVENT;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.Team.TEAM;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;

@Repository
@RequiredArgsConstructor
public class GameRepositoryImpl implements GameRepository {

    private final DSLContext dsl;

    private GameDao gameDao;

    @PostConstruct
    void initGameDao() {
        gameDao = new GameDao(dsl.configuration());
    }

    @Override
    public long save(Game game) {
        gameDao.insert(game);
        return game.getId();
    }

    @Override
    public void update(Game game) {
        gameDao.update(game);
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

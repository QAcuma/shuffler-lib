package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Game;
import ru.acuma.shufflerlib.dao.GameDao;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameDaoImpl implements GameDao {

    private final DSLContext dsl;

    @Override
    public void save(Game game) {

    }

    @Override
    public List<Game> findAllBySeasonId(Long seasonId, Long chatId, Discipline discipline) {
        return null;
    }

    @Override
    public List<Game> findAllByEventId(Long eventId, Long chatId, Discipline discipline) {
        return null;
    }

    @Override
    public List<Game> findAllByPlayerIdAndSeasonIds(Long playerId, List<Long> seasonIds, Long chatId, Discipline discipline) {
        return null;
    }
}

package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.Game;

import java.util.List;

public interface GameDao {

    void save(Game game);

    List<Game> findAllBySeasonId(Long seasonId);

    List<Game> findAllByEventId(Long eventId);

    List<Game> findAllByPlayerIdAndSeasonIds(Long playerId, List<Long> seasonIds);

}

package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Game;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

public interface GameDao {

    long save(Game game);

    List<Game> findAllBySeasonId(Long seasonId, Long chatId, Discipline discipline);

    List<Game> findAllByEventId(Long eventId, Long chatId, Discipline discipline);

    List<Game> findAllByPlayerIdAndSeasonIds(Long playerId, List<Long> seasonIds, Long chatId, Discipline discipline);

}

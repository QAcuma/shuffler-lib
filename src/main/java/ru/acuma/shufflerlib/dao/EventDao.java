package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.Event;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

public interface EventDao {

    void save(Event event);

    Event findById(Long id);

    List<Event> findAllBySeasonId(Long seasonId, Long chatId, Discipline discipline);

    List<Event> findAllByPlayerId(Long playerId, Long chatId, Discipline discipline);
}

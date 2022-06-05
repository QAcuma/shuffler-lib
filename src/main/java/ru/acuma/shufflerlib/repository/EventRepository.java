package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Event;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

public interface EventRepository {

    long save(Event event);

    void update(Event event);

    Event findById(Long id);

    List<Event> findAllBySeasonId(Long seasonId, Long chatId, Discipline discipline);

    List<Event> findAllByPlayerId(Long playerId, Long chatId, Discipline discipline);
}

package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.Event;

import java.util.List;

public interface EventDao {

    void save(Event event);

    List<Event> findAllBySeasonId(Long seasonId);

    List<Event> findAllByPlayerId(Long playerId);
}

package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Event;
import ru.acuma.shufflerlib.dao.EventDao;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventDaoImpl implements EventDao {

    private final DSLContext dsl;

    @Override
    public void save(Event event) {

    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAllBySeasonId(Long seasonId, Long chatId, Discipline discipline) {
        return null;
    }

    @Override
    public List<Event> findAllByPlayerId(Long playerId, Long chatId, Discipline discipline) {
        return null;
    }
}

package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Event;
import ru.acuma.shufflerlib.dao.EventDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventDaoImpl implements EventDao {

    private final DSLContext dsl;

    @Override
    public void save(Event event) {

    }

    @Override
    public List<Event> findAllBySeasonId(Long seasonId) {
        return null;
    }

    @Override
    public List<Event> findAllByPlayerId(Long playerId) {
        return null;
    }
}

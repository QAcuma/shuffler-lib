package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Event;
import ru.acuma.k.shuffler.tables.records.EventRecord;
import ru.acuma.k.shuffler.tables.records.GameRecord;
import ru.acuma.shufflerlib.dao.EventDao;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

import static ru.acuma.k.shuffler.tables.Event.EVENT;
import static ru.acuma.k.shuffler.tables.Game.GAME;

@Repository
@RequiredArgsConstructor
public class EventDaoImpl implements EventDao {

    private final DSLContext dsl;

    @Override
    public long save(Event event) {
        EventRecord record = dsl.newRecord(EVENT, event);
        record.store();
        return record.getId();
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

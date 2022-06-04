package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.Event;
import ru.acuma.shuffler.tables.records.EventRecord;
import ru.acuma.shufflerlib.dao.EventDao;
import ru.acuma.shufflerlib.model.Discipline;

import java.util.List;

import static ru.acuma.shuffler.tables.Event.EVENT;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.Team.TEAM;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;

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
        return dsl.select()
                .from(EVENT)
                .where(EVENT.ID.eq(id))
                .fetchOneInto(Event.class);
    }

    @Override
    public List<Event> findAllBySeasonId(Long seasonId, Long chatId, Discipline discipline) {
        return dsl.select()
                .from(EVENT)
                .where(EVENT.SEASON_ID.eq(seasonId))
                .and(EVENT.CHAT_ID.eq(chatId))
                .and(EVENT.DISCIPLINE.eq(discipline.name()))
                .fetchInto(Event.class);
    }

    @Override
    public List<Event> findAllByPlayerId(Long playerId, Long chatId, Discipline discipline) {
        return dsl.select(EVENT.fields())
                .from(EVENT)
                .join(GAME).on(GAME.EVENT_ID.eq(EVENT.ID))
                .join(TEAM).on(TEAM.GAME_ID.eq(GAME.ID))
                .join(TEAM_PLAYER).on(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                .where(EVENT.CHAT_ID.eq(chatId))
                .and(EVENT.DISCIPLINE.eq(discipline.name()))
                .and(TEAM_PLAYER.PLAYER_ID.eq(playerId))
                .fetchInto(Event.class);
    }
}

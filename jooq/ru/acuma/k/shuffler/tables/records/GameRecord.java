/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables.records;


import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.k.shuffler.tables.Game;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GameRecord extends UpdatableRecordImpl<GameRecord> implements Record4<Long, Long, OffsetDateTime, OffsetDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.game.id</code>.
     */
    public GameRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.game.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.game.event_id</code>.
     */
    public GameRecord setEventId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.game.event_id</code>.
     */
    public Long getEventId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.game.started_at</code>.
     */
    public GameRecord setStartedAt(OffsetDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.game.started_at</code>.
     */
    public OffsetDateTime getStartedAt() {
        return (OffsetDateTime) get(2);
    }

    /**
     * Setter for <code>public.game.finished_at</code>.
     */
    public GameRecord setFinishedAt(OffsetDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.game.finished_at</code>.
     */
    public OffsetDateTime getFinishedAt() {
        return (OffsetDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Long, OffsetDateTime, OffsetDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Game.GAME.ID;
    }

    @Override
    public Field<Long> field2() {
        return Game.GAME.EVENT_ID;
    }

    @Override
    public Field<OffsetDateTime> field3() {
        return Game.GAME.STARTED_AT;
    }

    @Override
    public Field<OffsetDateTime> field4() {
        return Game.GAME.FINISHED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getEventId();
    }

    @Override
    public OffsetDateTime component3() {
        return getStartedAt();
    }

    @Override
    public OffsetDateTime component4() {
        return getFinishedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getEventId();
    }

    @Override
    public OffsetDateTime value3() {
        return getStartedAt();
    }

    @Override
    public OffsetDateTime value4() {
        return getFinishedAt();
    }

    @Override
    public GameRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public GameRecord value2(Long value) {
        setEventId(value);
        return this;
    }

    @Override
    public GameRecord value3(OffsetDateTime value) {
        setStartedAt(value);
        return this;
    }

    @Override
    public GameRecord value4(OffsetDateTime value) {
        setFinishedAt(value);
        return this;
    }

    @Override
    public GameRecord values(Long value1, Long value2, OffsetDateTime value3, OffsetDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GameRecord
     */
    public GameRecord() {
        super(Game.GAME);
    }

    /**
     * Create a detached, initialised GameRecord
     */
    public GameRecord(Long id, Long eventId, OffsetDateTime startedAt, OffsetDateTime finishedAt) {
        super(Game.GAME);

        setId(id);
        setEventId(eventId);
        setStartedAt(startedAt);
        setFinishedAt(finishedAt);
    }

    /**
     * Create a detached, initialised GameRecord
     */
    public GameRecord(ru.acuma.k.shuffler.tables.pojos.Game value) {
        super(Game.GAME);

        if (value != null) {
            setId(value.getId());
            setEventId(value.getEventId());
            setStartedAt(value.getStartedAt());
            setFinishedAt(value.getFinishedAt());
        }
    }
}

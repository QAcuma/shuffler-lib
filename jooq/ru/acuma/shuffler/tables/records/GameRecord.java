/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.records;


import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.shuffler.tables.Game;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GameRecord extends UpdatableRecordImpl<GameRecord> implements Record5<Long, Long, String, OffsetDateTime, OffsetDateTime> {

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
     * Setter for <code>public.game.state</code>.
     */
    public GameRecord setState(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.game.state</code>.
     */
    public String getState() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.game.started_at</code>.
     */
    public GameRecord setStartedAt(OffsetDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.game.started_at</code>.
     */
    public OffsetDateTime getStartedAt() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>public.game.finished_at</code>.
     */
    public GameRecord setFinishedAt(OffsetDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.game.finished_at</code>.
     */
    public OffsetDateTime getFinishedAt() {
        return (OffsetDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, String, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Long, String, OffsetDateTime, OffsetDateTime> valuesRow() {
        return (Row5) super.valuesRow();
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
    public Field<String> field3() {
        return Game.GAME.STATE;
    }

    @Override
    public Field<OffsetDateTime> field4() {
        return Game.GAME.STARTED_AT;
    }

    @Override
    public Field<OffsetDateTime> field5() {
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
    public String component3() {
        return getState();
    }

    @Override
    public OffsetDateTime component4() {
        return getStartedAt();
    }

    @Override
    public OffsetDateTime component5() {
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
    public String value3() {
        return getState();
    }

    @Override
    public OffsetDateTime value4() {
        return getStartedAt();
    }

    @Override
    public OffsetDateTime value5() {
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
    public GameRecord value3(String value) {
        setState(value);
        return this;
    }

    @Override
    public GameRecord value4(OffsetDateTime value) {
        setStartedAt(value);
        return this;
    }

    @Override
    public GameRecord value5(OffsetDateTime value) {
        setFinishedAt(value);
        return this;
    }

    @Override
    public GameRecord values(Long value1, Long value2, String value3, OffsetDateTime value4, OffsetDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
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
    public GameRecord(Long id, Long eventId, String state, OffsetDateTime startedAt, OffsetDateTime finishedAt) {
        super(Game.GAME);

        setId(id);
        setEventId(eventId);
        setState(state);
        setStartedAt(startedAt);
        setFinishedAt(finishedAt);
    }

    /**
     * Create a detached, initialised GameRecord
     */
    public GameRecord(ru.acuma.shuffler.tables.pojos.Game value) {
        super(Game.GAME);

        if (value != null) {
            setId(value.getId());
            setEventId(value.getEventId());
            setState(value.getState());
            setStartedAt(value.getStartedAt());
            setFinishedAt(value.getFinishedAt());
        }
    }
}

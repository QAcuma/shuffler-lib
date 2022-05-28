/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables.records;


import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.k.shuffler.tables.Event;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EventRecord extends UpdatableRecordImpl<EventRecord> implements Record7<Long, Long, Long, String, OffsetDateTime, OffsetDateTime, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.event.id</code>.
     */
    public EventRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.event.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.event.chat_id</code>.
     */
    public EventRecord setChatId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.event.chat_id</code>.
     */
    public Long getChatId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.event.season_id</code>.
     */
    public EventRecord setSeasonId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.event.season_id</code>.
     */
    public Long getSeasonId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.event.status</code>.
     */
    public EventRecord setStatus(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.event.status</code>.
     */
    public String getStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.event.started_at</code>.
     */
    public EventRecord setStartedAt(OffsetDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.event.started_at</code>.
     */
    public OffsetDateTime getStartedAt() {
        return (OffsetDateTime) get(4);
    }

    /**
     * Setter for <code>public.event.finished_at</code>.
     */
    public EventRecord setFinishedAt(OffsetDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.event.finished_at</code>.
     */
    public OffsetDateTime getFinishedAt() {
        return (OffsetDateTime) get(5);
    }

    /**
     * Setter for <code>public.event.discipline</code>.
     */
    public EventRecord setDiscipline(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.event.discipline</code>.
     */
    public String getDiscipline() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, Long, String, OffsetDateTime, OffsetDateTime, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, Long, Long, String, OffsetDateTime, OffsetDateTime, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Event.EVENT.ID;
    }

    @Override
    public Field<Long> field2() {
        return Event.EVENT.CHAT_ID;
    }

    @Override
    public Field<Long> field3() {
        return Event.EVENT.SEASON_ID;
    }

    @Override
    public Field<String> field4() {
        return Event.EVENT.STATUS;
    }

    @Override
    public Field<OffsetDateTime> field5() {
        return Event.EVENT.STARTED_AT;
    }

    @Override
    public Field<OffsetDateTime> field6() {
        return Event.EVENT.FINISHED_AT;
    }

    @Override
    public Field<String> field7() {
        return Event.EVENT.DISCIPLINE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getChatId();
    }

    @Override
    public Long component3() {
        return getSeasonId();
    }

    @Override
    public String component4() {
        return getStatus();
    }

    @Override
    public OffsetDateTime component5() {
        return getStartedAt();
    }

    @Override
    public OffsetDateTime component6() {
        return getFinishedAt();
    }

    @Override
    public String component7() {
        return getDiscipline();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getChatId();
    }

    @Override
    public Long value3() {
        return getSeasonId();
    }

    @Override
    public String value4() {
        return getStatus();
    }

    @Override
    public OffsetDateTime value5() {
        return getStartedAt();
    }

    @Override
    public OffsetDateTime value6() {
        return getFinishedAt();
    }

    @Override
    public String value7() {
        return getDiscipline();
    }

    @Override
    public EventRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public EventRecord value2(Long value) {
        setChatId(value);
        return this;
    }

    @Override
    public EventRecord value3(Long value) {
        setSeasonId(value);
        return this;
    }

    @Override
    public EventRecord value4(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public EventRecord value5(OffsetDateTime value) {
        setStartedAt(value);
        return this;
    }

    @Override
    public EventRecord value6(OffsetDateTime value) {
        setFinishedAt(value);
        return this;
    }

    @Override
    public EventRecord value7(String value) {
        setDiscipline(value);
        return this;
    }

    @Override
    public EventRecord values(Long value1, Long value2, Long value3, String value4, OffsetDateTime value5, OffsetDateTime value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EventRecord
     */
    public EventRecord() {
        super(Event.EVENT);
    }

    /**
     * Create a detached, initialised EventRecord
     */
    public EventRecord(Long id, Long chatId, Long seasonId, String status, OffsetDateTime startedAt, OffsetDateTime finishedAt, String discipline) {
        super(Event.EVENT);

        setId(id);
        setChatId(chatId);
        setSeasonId(seasonId);
        setStatus(status);
        setStartedAt(startedAt);
        setFinishedAt(finishedAt);
        setDiscipline(discipline);
    }

    /**
     * Create a detached, initialised EventRecord
     */
    public EventRecord(ru.acuma.k.shuffler.tables.pojos.Event value) {
        super(Event.EVENT);

        if (value != null) {
            setId(value.getId());
            setChatId(value.getChatId());
            setSeasonId(value.getSeasonId());
            setStatus(value.getStatus());
            setStartedAt(value.getStartedAt());
            setFinishedAt(value.getFinishedAt());
            setDiscipline(value.getDiscipline());
        }
    }
}

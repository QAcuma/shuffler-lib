/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.k.shuffler.tables.Rating;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RatingRecord extends UpdatableRecordImpl<RatingRecord> implements Record4<Long, Long, Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.rating.id</code>.
     */
    public RatingRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.rating.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.rating.player_id</code>.
     */
    public RatingRecord setPlayerId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.rating.player_id</code>.
     */
    public Long getPlayerId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.rating.season_id</code>.
     */
    public RatingRecord setSeasonId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.rating.season_id</code>.
     */
    public Long getSeasonId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.rating.discipline</code>.
     */
    public RatingRecord setDiscipline(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.rating.discipline</code>.
     */
    public String getDiscipline() {
        return (String) get(3);
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
    public Row4<Long, Long, Long, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Long, Long, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Rating.RATING.ID;
    }

    @Override
    public Field<Long> field2() {
        return Rating.RATING.PLAYER_ID;
    }

    @Override
    public Field<Long> field3() {
        return Rating.RATING.SEASON_ID;
    }

    @Override
    public Field<String> field4() {
        return Rating.RATING.DISCIPLINE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getPlayerId();
    }

    @Override
    public Long component3() {
        return getSeasonId();
    }

    @Override
    public String component4() {
        return getDiscipline();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getPlayerId();
    }

    @Override
    public Long value3() {
        return getSeasonId();
    }

    @Override
    public String value4() {
        return getDiscipline();
    }

    @Override
    public RatingRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public RatingRecord value2(Long value) {
        setPlayerId(value);
        return this;
    }

    @Override
    public RatingRecord value3(Long value) {
        setSeasonId(value);
        return this;
    }

    @Override
    public RatingRecord value4(String value) {
        setDiscipline(value);
        return this;
    }

    @Override
    public RatingRecord values(Long value1, Long value2, Long value3, String value4) {
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
     * Create a detached RatingRecord
     */
    public RatingRecord() {
        super(Rating.RATING);
    }

    /**
     * Create a detached, initialised RatingRecord
     */
    public RatingRecord(Long id, Long playerId, Long seasonId, String discipline) {
        super(Rating.RATING);

        setId(id);
        setPlayerId(playerId);
        setSeasonId(seasonId);
        setDiscipline(discipline);
    }

    /**
     * Create a detached, initialised RatingRecord
     */
    public RatingRecord(ru.acuma.k.shuffler.tables.pojos.Rating value) {
        super(Rating.RATING);

        if (value != null) {
            setId(value.getId());
            setPlayerId(value.getPlayerId());
            setSeasonId(value.getSeasonId());
            setDiscipline(value.getDiscipline());
        }
    }
}
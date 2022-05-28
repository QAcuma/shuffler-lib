/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.k.shuffler.tables.RatingHistory;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RatingHistoryRecord extends UpdatableRecordImpl<RatingHistoryRecord> implements Record6<Long, Long, Long, Long, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.rating_history.id</code>.
     */
    public RatingHistoryRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.rating_history.player_id</code>.
     */
    public RatingHistoryRecord setPlayerId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.player_id</code>.
     */
    public Long getPlayerId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.rating_history.game_id</code>.
     */
    public RatingHistoryRecord setGameId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.game_id</code>.
     */
    public Long getGameId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.rating_history.season_id</code>.
     */
    public RatingHistoryRecord setSeasonId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.season_id</code>.
     */
    public Long getSeasonId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.rating_history.discipline</code>.
     */
    public RatingHistoryRecord setDiscipline(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.discipline</code>.
     */
    public String getDiscipline() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.rating_history.change</code>.
     */
    public RatingHistoryRecord setChange(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.change</code>.
     */
    public Integer getChange() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, Long, Long, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, Long, Long, Long, String, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return RatingHistory.RATING_HISTORY.ID;
    }

    @Override
    public Field<Long> field2() {
        return RatingHistory.RATING_HISTORY.PLAYER_ID;
    }

    @Override
    public Field<Long> field3() {
        return RatingHistory.RATING_HISTORY.GAME_ID;
    }

    @Override
    public Field<Long> field4() {
        return RatingHistory.RATING_HISTORY.SEASON_ID;
    }

    @Override
    public Field<String> field5() {
        return RatingHistory.RATING_HISTORY.DISCIPLINE;
    }

    @Override
    public Field<Integer> field6() {
        return RatingHistory.RATING_HISTORY.CHANGE;
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
        return getGameId();
    }

    @Override
    public Long component4() {
        return getSeasonId();
    }

    @Override
    public String component5() {
        return getDiscipline();
    }

    @Override
    public Integer component6() {
        return getChange();
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
        return getGameId();
    }

    @Override
    public Long value4() {
        return getSeasonId();
    }

    @Override
    public String value5() {
        return getDiscipline();
    }

    @Override
    public Integer value6() {
        return getChange();
    }

    @Override
    public RatingHistoryRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value2(Long value) {
        setPlayerId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value3(Long value) {
        setGameId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value4(Long value) {
        setSeasonId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value5(String value) {
        setDiscipline(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value6(Integer value) {
        setChange(value);
        return this;
    }

    @Override
    public RatingHistoryRecord values(Long value1, Long value2, Long value3, Long value4, String value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RatingHistoryRecord
     */
    public RatingHistoryRecord() {
        super(RatingHistory.RATING_HISTORY);
    }

    /**
     * Create a detached, initialised RatingHistoryRecord
     */
    public RatingHistoryRecord(Long id, Long playerId, Long gameId, Long seasonId, String discipline, Integer change) {
        super(RatingHistory.RATING_HISTORY);

        setId(id);
        setPlayerId(playerId);
        setGameId(gameId);
        setSeasonId(seasonId);
        setDiscipline(discipline);
        setChange(change);
    }

    /**
     * Create a detached, initialised RatingHistoryRecord
     */
    public RatingHistoryRecord(ru.acuma.k.shuffler.tables.pojos.RatingHistory value) {
        super(RatingHistory.RATING_HISTORY);

        if (value != null) {
            setId(value.getId());
            setPlayerId(value.getPlayerId());
            setGameId(value.getGameId());
            setSeasonId(value.getSeasonId());
            setDiscipline(value.getDiscipline());
            setChange(value.getChange());
        }
    }
}

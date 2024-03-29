/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
import ru.acuma.shuffler.tables.RatingHistory;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class RatingHistoryRecord extends UpdatableRecordImpl<RatingHistoryRecord> implements Record8<Long, Long, Long, Integer, Integer, Long, Boolean, String> {

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
     * Setter for <code>public.rating_history.game_id</code>.
     */
    public RatingHistoryRecord setGameId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.game_id</code>.
     */
    public Long getGameId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.rating_history.player_id</code>.
     */
    public RatingHistoryRecord setPlayerId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.player_id</code>.
     */
    public Long getPlayerId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.rating_history.change</code>.
     */
    public RatingHistoryRecord setChange(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.change</code>.
     */
    public Integer getChange() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.rating_history.score</code>.
     */
    public RatingHistoryRecord setScore(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.score</code>.
     */
    public Integer getScore() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.rating_history.season_id</code>.
     */
    public RatingHistoryRecord setSeasonId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.season_id</code>.
     */
    public Long getSeasonId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.rating_history.is_calibrated</code>.
     */
    public RatingHistoryRecord setIsCalibrated(Boolean value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.is_calibrated</code>.
     */
    public Boolean getIsCalibrated() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>public.rating_history.discipline</code>.
     */
    public RatingHistoryRecord setDiscipline(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.rating_history.discipline</code>.
     */
    public String getDiscipline() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, Long, Integer, Integer, Long, Boolean, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, Long, Long, Integer, Integer, Long, Boolean, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return RatingHistory.RATING_HISTORY.ID;
    }

    @Override
    public Field<Long> field2() {
        return RatingHistory.RATING_HISTORY.GAME_ID;
    }

    @Override
    public Field<Long> field3() {
        return RatingHistory.RATING_HISTORY.PLAYER_ID;
    }

    @Override
    public Field<Integer> field4() {
        return RatingHistory.RATING_HISTORY.CHANGE;
    }

    @Override
    public Field<Integer> field5() {
        return RatingHistory.RATING_HISTORY.SCORE;
    }

    @Override
    public Field<Long> field6() {
        return RatingHistory.RATING_HISTORY.SEASON_ID;
    }

    @Override
    public Field<Boolean> field7() {
        return RatingHistory.RATING_HISTORY.IS_CALIBRATED;
    }

    @Override
    public Field<String> field8() {
        return RatingHistory.RATING_HISTORY.DISCIPLINE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getGameId();
    }

    @Override
    public Long component3() {
        return getPlayerId();
    }

    @Override
    public Integer component4() {
        return getChange();
    }

    @Override
    public Integer component5() {
        return getScore();
    }

    @Override
    public Long component6() {
        return getSeasonId();
    }

    @Override
    public Boolean component7() {
        return getIsCalibrated();
    }

    @Override
    public String component8() {
        return getDiscipline();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getGameId();
    }

    @Override
    public Long value3() {
        return getPlayerId();
    }

    @Override
    public Integer value4() {
        return getChange();
    }

    @Override
    public Integer value5() {
        return getScore();
    }

    @Override
    public Long value6() {
        return getSeasonId();
    }

    @Override
    public Boolean value7() {
        return getIsCalibrated();
    }

    @Override
    public String value8() {
        return getDiscipline();
    }

    @Override
    public RatingHistoryRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value2(Long value) {
        setGameId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value3(Long value) {
        setPlayerId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value4(Integer value) {
        setChange(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value5(Integer value) {
        setScore(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value6(Long value) {
        setSeasonId(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value7(Boolean value) {
        setIsCalibrated(value);
        return this;
    }

    @Override
    public RatingHistoryRecord value8(String value) {
        setDiscipline(value);
        return this;
    }

    @Override
    public RatingHistoryRecord values(Long value1, Long value2, Long value3, Integer value4, Integer value5, Long value6, Boolean value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
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
    public RatingHistoryRecord(Long id, Long gameId, Long playerId, Integer change, Integer score, Long seasonId, Boolean isCalibrated, String discipline) {
        super(RatingHistory.RATING_HISTORY);

        setId(id);
        setGameId(gameId);
        setPlayerId(playerId);
        setChange(change);
        setScore(score);
        setSeasonId(seasonId);
        setIsCalibrated(isCalibrated);
        setDiscipline(discipline);
    }

    /**
     * Create a detached, initialised RatingHistoryRecord
     */
    public RatingHistoryRecord(ru.acuma.shuffler.tables.pojos.RatingHistory value) {
        super(RatingHistory.RATING_HISTORY);

        if (value != null) {
            setId(value.getId());
            setGameId(value.getGameId());
            setPlayerId(value.getPlayerId());
            setChange(value.getChange());
            setScore(value.getScore());
            setSeasonId(value.getSeasonId());
            setIsCalibrated(value.getIsCalibrated());
            setDiscipline(value.getDiscipline());
        }
    }
}

/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.k.shuffler.tables.Player;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlayerRecord extends UpdatableRecordImpl<PlayerRecord> implements Record5<Long, Long, Long, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.player.id</code>.
     */
    public PlayerRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.player.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.player.chat_id</code>.
     */
    public PlayerRecord setChatId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.player.chat_id</code>.
     */
    public Long getChatId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.player.user_id</code>.
     */
    public PlayerRecord setUserId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.player.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.player.season_id</code>.
     */
    public PlayerRecord setSeasonId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.player.season_id</code>.
     */
    public Long getSeasonId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.player.discipline</code>.
     */
    public PlayerRecord setDiscipline(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.player.discipline</code>.
     */
    public Long getDiscipline() {
        return (Long) get(4);
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
    public Row5<Long, Long, Long, Long, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Long, Long, Long, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Player.PLAYER.ID;
    }

    @Override
    public Field<Long> field2() {
        return Player.PLAYER.CHAT_ID;
    }

    @Override
    public Field<Long> field3() {
        return Player.PLAYER.USER_ID;
    }

    @Override
    public Field<Long> field4() {
        return Player.PLAYER.SEASON_ID;
    }

    @Override
    public Field<Long> field5() {
        return Player.PLAYER.DISCIPLINE;
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
        return getUserId();
    }

    @Override
    public Long component4() {
        return getSeasonId();
    }

    @Override
    public Long component5() {
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
        return getUserId();
    }

    @Override
    public Long value4() {
        return getSeasonId();
    }

    @Override
    public Long value5() {
        return getDiscipline();
    }

    @Override
    public PlayerRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public PlayerRecord value2(Long value) {
        setChatId(value);
        return this;
    }

    @Override
    public PlayerRecord value3(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public PlayerRecord value4(Long value) {
        setSeasonId(value);
        return this;
    }

    @Override
    public PlayerRecord value5(Long value) {
        setDiscipline(value);
        return this;
    }

    @Override
    public PlayerRecord values(Long value1, Long value2, Long value3, Long value4, Long value5) {
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
     * Create a detached PlayerRecord
     */
    public PlayerRecord() {
        super(Player.PLAYER);
    }

    /**
     * Create a detached, initialised PlayerRecord
     */
    public PlayerRecord(Long id, Long chatId, Long userId, Long seasonId, Long discipline) {
        super(Player.PLAYER);

        setId(id);
        setChatId(chatId);
        setUserId(userId);
        setSeasonId(seasonId);
        setDiscipline(discipline);
    }

    /**
     * Create a detached, initialised PlayerRecord
     */
    public PlayerRecord(ru.acuma.k.shuffler.tables.pojos.Player value) {
        super(Player.PLAYER);

        if (value != null) {
            setId(value.getId());
            setChatId(value.getChatId());
            setUserId(value.getUserId());
            setSeasonId(value.getSeasonId());
            setDiscipline(value.getDiscipline());
        }
    }
}

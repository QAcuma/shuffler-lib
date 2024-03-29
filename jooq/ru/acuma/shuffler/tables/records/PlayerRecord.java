/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.shuffler.tables.Player;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlayerRecord extends UpdatableRecordImpl<PlayerRecord> implements Record3<Long, Long, Long> {

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

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
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
    public PlayerRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
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
    public PlayerRecord(Long id, Long chatId, Long userId) {
        super(Player.PLAYER);

        setId(id);
        setChatId(chatId);
        setUserId(userId);
    }

    /**
     * Create a detached, initialised PlayerRecord
     */
    public PlayerRecord(ru.acuma.shuffler.tables.pojos.Player value) {
        super(Player.PLAYER);

        if (value != null) {
            setId(value.getId());
            setChatId(value.getChatId());
            setUserId(value.getUserId());
        }
    }
}

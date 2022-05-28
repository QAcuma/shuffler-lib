/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables;


import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.acuma.k.shuffler.Keys;
import ru.acuma.k.shuffler.Public;
import ru.acuma.k.shuffler.tables.records.GameRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Game extends TableImpl<GameRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.game</code>
     */
    public static final Game GAME = new Game();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GameRecord> getRecordType() {
        return GameRecord.class;
    }

    /**
     * The column <code>public.game.id</code>.
     */
    public final TableField<GameRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.game.event_id</code>.
     */
    public final TableField<GameRecord, Long> EVENT_ID = createField(DSL.name("event_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.game.index</code>.
     */
    public final TableField<GameRecord, Integer> INDEX = createField(DSL.name("index"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.game.started_at</code>.
     */
    public final TableField<GameRecord, OffsetDateTime> STARTED_AT = createField(DSL.name("started_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "");

    /**
     * The column <code>public.game.finished_at</code>.
     */
    public final TableField<GameRecord, OffsetDateTime> FINISHED_AT = createField(DSL.name("finished_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    private Game(Name alias, Table<GameRecord> aliased) {
        this(alias, aliased, null);
    }

    private Game(Name alias, Table<GameRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.game</code> table reference
     */
    public Game(String alias) {
        this(DSL.name(alias), GAME);
    }

    /**
     * Create an aliased <code>public.game</code> table reference
     */
    public Game(Name alias) {
        this(alias, GAME);
    }

    /**
     * Create a <code>public.game</code> table reference
     */
    public Game() {
        this(DSL.name("game"), null);
    }

    public <O extends Record> Game(Table<O> child, ForeignKey<O, GameRecord> key) {
        super(child, key, GAME);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<GameRecord, Long> getIdentity() {
        return (Identity<GameRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<GameRecord> getPrimaryKey() {
        return Keys.GAME_PKEY;
    }

    @Override
    public List<ForeignKey<GameRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GAME__FK_EXISTS_EVENT);
    }

    private transient Event _event;

    /**
     * Get the implicit join path to the <code>public.event</code> table.
     */
    public Event event() {
        if (_event == null)
            _event = new Event(this, Keys.GAME__FK_EXISTS_EVENT);

        return _event;
    }

    @Override
    public Game as(String alias) {
        return new Game(DSL.name(alias), this);
    }

    @Override
    public Game as(Name alias) {
        return new Game(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Game rename(String name) {
        return new Game(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Game rename(Name name) {
        return new Game(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Integer, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}

/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
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
import ru.acuma.k.shuffler.tables.records.RatingHistoryRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RatingHistory extends TableImpl<RatingHistoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.rating_history</code>
     */
    public static final RatingHistory RATING_HISTORY = new RatingHistory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RatingHistoryRecord> getRecordType() {
        return RatingHistoryRecord.class;
    }

    /**
     * The column <code>public.rating_history.id</code>.
     */
    public final TableField<RatingHistoryRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.rating_history.player_id</code>.
     */
    public final TableField<RatingHistoryRecord, Long> PLAYER_ID = createField(DSL.name("player_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rating_history.game_id</code>.
     */
    public final TableField<RatingHistoryRecord, Long> GAME_ID = createField(DSL.name("game_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rating_history.season_id</code>.
     */
    public final TableField<RatingHistoryRecord, Long> SEASON_ID = createField(DSL.name("season_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rating_history.discipline</code>.
     */
    public final TableField<RatingHistoryRecord, String> DISCIPLINE = createField(DSL.name("discipline"), SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>public.rating_history.change</code>.
     */
    public final TableField<RatingHistoryRecord, Integer> CHANGE = createField(DSL.name("change"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.rating_history.chat_id</code>.
     */
    public final TableField<RatingHistoryRecord, Long> CHAT_ID = createField(DSL.name("chat_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private RatingHistory(Name alias, Table<RatingHistoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private RatingHistory(Name alias, Table<RatingHistoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.rating_history</code> table reference
     */
    public RatingHistory(String alias) {
        this(DSL.name(alias), RATING_HISTORY);
    }

    /**
     * Create an aliased <code>public.rating_history</code> table reference
     */
    public RatingHistory(Name alias) {
        this(alias, RATING_HISTORY);
    }

    /**
     * Create a <code>public.rating_history</code> table reference
     */
    public RatingHistory() {
        this(DSL.name("rating_history"), null);
    }

    public <O extends Record> RatingHistory(Table<O> child, ForeignKey<O, RatingHistoryRecord> key) {
        super(child, key, RATING_HISTORY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<RatingHistoryRecord, Long> getIdentity() {
        return (Identity<RatingHistoryRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<RatingHistoryRecord> getPrimaryKey() {
        return Keys.RATING_HISTORY_PKEY;
    }

    @Override
    public List<ForeignKey<RatingHistoryRecord, ?>> getReferences() {
        return Arrays.asList(Keys.RATING_HISTORY__FK_EXISTS_PLAYER, Keys.RATING_HISTORY__FK_EXISTS_GAME, Keys.RATING_HISTORY__FK_EXISTS_SEASON, Keys.RATING_HISTORY__FK_EXISTS_CHAT);
    }

    private transient Player _player;
    private transient Game _game;
    private transient Season _season;
    private transient GroupInfo _groupInfo;

    /**
     * Get the implicit join path to the <code>public.player</code> table.
     */
    public Player player() {
        if (_player == null)
            _player = new Player(this, Keys.RATING_HISTORY__FK_EXISTS_PLAYER);

        return _player;
    }

    /**
     * Get the implicit join path to the <code>public.game</code> table.
     */
    public Game game() {
        if (_game == null)
            _game = new Game(this, Keys.RATING_HISTORY__FK_EXISTS_GAME);

        return _game;
    }

    /**
     * Get the implicit join path to the <code>public.season</code> table.
     */
    public Season season() {
        if (_season == null)
            _season = new Season(this, Keys.RATING_HISTORY__FK_EXISTS_SEASON);

        return _season;
    }

    /**
     * Get the implicit join path to the <code>public.group_info</code> table.
     */
    public GroupInfo groupInfo() {
        if (_groupInfo == null)
            _groupInfo = new GroupInfo(this, Keys.RATING_HISTORY__FK_EXISTS_CHAT);

        return _groupInfo;
    }

    @Override
    public RatingHistory as(String alias) {
        return new RatingHistory(DSL.name(alias), this);
    }

    @Override
    public RatingHistory as(Name alias) {
        return new RatingHistory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RatingHistory rename(String name) {
        return new RatingHistory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RatingHistory rename(Name name) {
        return new RatingHistory(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, Long, Long, String, Integer, Long> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}

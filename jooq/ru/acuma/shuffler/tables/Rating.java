/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables;


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

import ru.acuma.shuffler.Keys;
import ru.acuma.shuffler.Public;
import ru.acuma.shuffler.tables.records.RatingRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Rating extends TableImpl<RatingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.rating</code>
     */
    public static final Rating RATING = new Rating();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RatingRecord> getRecordType() {
        return RatingRecord.class;
    }

    /**
     * The column <code>public.rating.id</code>.
     */
    public final TableField<RatingRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.rating.player_id</code>.
     */
    public final TableField<RatingRecord, Long> PLAYER_ID = createField(DSL.name("player_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rating.season_id</code>.
     */
    public final TableField<RatingRecord, Long> SEASON_ID = createField(DSL.name("season_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rating.discipline</code>.
     */
    public final TableField<RatingRecord, String> DISCIPLINE = createField(DSL.name("discipline"), SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>public.rating.score</code>.
     */
    public final TableField<RatingRecord, Integer> SCORE = createField(DSL.name("score"), SQLDataType.INTEGER.nullable(false), this, "");

    private Rating(Name alias, Table<RatingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Rating(Name alias, Table<RatingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.rating</code> table reference
     */
    public Rating(String alias) {
        this(DSL.name(alias), RATING);
    }

    /**
     * Create an aliased <code>public.rating</code> table reference
     */
    public Rating(Name alias) {
        this(alias, RATING);
    }

    /**
     * Create a <code>public.rating</code> table reference
     */
    public Rating() {
        this(DSL.name("rating"), null);
    }

    public <O extends Record> Rating(Table<O> child, ForeignKey<O, RatingRecord> key) {
        super(child, key, RATING);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<RatingRecord, Long> getIdentity() {
        return (Identity<RatingRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<RatingRecord> getPrimaryKey() {
        return Keys.RATING_PKEY;
    }

    @Override
    public List<ForeignKey<RatingRecord, ?>> getReferences() {
        return Arrays.asList(Keys.RATING__FK_EXISTS_PLAYER, Keys.RATING__FK_EXISTS_SEASON);
    }

    private transient Player _player;
    private transient Season _season;

    /**
     * Get the implicit join path to the <code>public.player</code> table.
     */
    public Player player() {
        if (_player == null)
            _player = new Player(this, Keys.RATING__FK_EXISTS_PLAYER);

        return _player;
    }

    /**
     * Get the implicit join path to the <code>public.season</code> table.
     */
    public Season season() {
        if (_season == null)
            _season = new Season(this, Keys.RATING__FK_EXISTS_SEASON);

        return _season;
    }

    @Override
    public Rating as(String alias) {
        return new Rating(DSL.name(alias), this);
    }

    @Override
    public Rating as(Name alias) {
        return new Rating(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Rating rename(String name) {
        return new Rating(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Rating rename(Name name) {
        return new Rating(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Long, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
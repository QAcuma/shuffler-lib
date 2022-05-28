/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables;


import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
import ru.acuma.k.shuffler.tables.records.SeasonRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Season extends TableImpl<SeasonRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.season</code>
     */
    public static final Season SEASON = new Season();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SeasonRecord> getRecordType() {
        return SeasonRecord.class;
    }

    /**
     * The column <code>public.season.id</code>.
     */
    public final TableField<SeasonRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.season.started_at</code>.
     */
    public final TableField<SeasonRecord, OffsetDateTime> STARTED_AT = createField(DSL.name("started_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>public.season.finished_at</code>.
     */
    public final TableField<SeasonRecord, OffsetDateTime> FINISHED_AT = createField(DSL.name("finished_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    private Season(Name alias, Table<SeasonRecord> aliased) {
        this(alias, aliased, null);
    }

    private Season(Name alias, Table<SeasonRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.season</code> table reference
     */
    public Season(String alias) {
        this(DSL.name(alias), SEASON);
    }

    /**
     * Create an aliased <code>public.season</code> table reference
     */
    public Season(Name alias) {
        this(alias, SEASON);
    }

    /**
     * Create a <code>public.season</code> table reference
     */
    public Season() {
        this(DSL.name("season"), null);
    }

    public <O extends Record> Season(Table<O> child, ForeignKey<O, SeasonRecord> key) {
        super(child, key, SEASON);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<SeasonRecord, Long> getIdentity() {
        return (Identity<SeasonRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<SeasonRecord> getPrimaryKey() {
        return Keys.SEASON_PKEY;
    }

    @Override
    public Season as(String alias) {
        return new Season(DSL.name(alias), this);
    }

    @Override
    public Season as(Name alias) {
        return new Season(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Season rename(String name) {
        return new Season(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Season rename(Name name) {
        return new Season(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}

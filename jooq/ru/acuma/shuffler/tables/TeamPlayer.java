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
import org.jooq.Row3;
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
import ru.acuma.shuffler.tables.records.TeamPlayerRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TeamPlayer extends TableImpl<TeamPlayerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.team_player</code>
     */
    public static final TeamPlayer TEAM_PLAYER = new TeamPlayer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TeamPlayerRecord> getRecordType() {
        return TeamPlayerRecord.class;
    }

    /**
     * The column <code>public.team_player.id</code>.
     */
    public final TableField<TeamPlayerRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.team_player.player_id</code>.
     */
    public final TableField<TeamPlayerRecord, Long> PLAYER_ID = createField(DSL.name("player_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.team_player.team_id</code>.
     */
    public final TableField<TeamPlayerRecord, Long> TEAM_ID = createField(DSL.name("team_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private TeamPlayer(Name alias, Table<TeamPlayerRecord> aliased) {
        this(alias, aliased, null);
    }

    private TeamPlayer(Name alias, Table<TeamPlayerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.team_player</code> table reference
     */
    public TeamPlayer(String alias) {
        this(DSL.name(alias), TEAM_PLAYER);
    }

    /**
     * Create an aliased <code>public.team_player</code> table reference
     */
    public TeamPlayer(Name alias) {
        this(alias, TEAM_PLAYER);
    }

    /**
     * Create a <code>public.team_player</code> table reference
     */
    public TeamPlayer() {
        this(DSL.name("team_player"), null);
    }

    public <O extends Record> TeamPlayer(Table<O> child, ForeignKey<O, TeamPlayerRecord> key) {
        super(child, key, TEAM_PLAYER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<TeamPlayerRecord, Long> getIdentity() {
        return (Identity<TeamPlayerRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<TeamPlayerRecord> getPrimaryKey() {
        return Keys.TEAM_PLAYER_PKEY;
    }

    @Override
    public List<ForeignKey<TeamPlayerRecord, ?>> getReferences() {
        return Arrays.asList(Keys.TEAM_PLAYER__FK_EXISTS_PLAYER, Keys.TEAM_PLAYER__FK_EXISTS_TEAM);
    }

    private transient Player _player;
    private transient Team _team;

    /**
     * Get the implicit join path to the <code>public.player</code> table.
     */
    public Player player() {
        if (_player == null)
            _player = new Player(this, Keys.TEAM_PLAYER__FK_EXISTS_PLAYER);

        return _player;
    }

    /**
     * Get the implicit join path to the <code>public.team</code> table.
     */
    public Team team() {
        if (_team == null)
            _team = new Team(this, Keys.TEAM_PLAYER__FK_EXISTS_TEAM);

        return _team;
    }

    @Override
    public TeamPlayer as(String alias) {
        return new TeamPlayer(DSL.name(alias), this);
    }

    @Override
    public TeamPlayer as(Name alias) {
        return new TeamPlayer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TeamPlayer rename(String name) {
        return new TeamPlayer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TeamPlayer rename(Name name) {
        return new TeamPlayer(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}

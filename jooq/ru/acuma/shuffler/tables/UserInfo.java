/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables;


import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
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
import ru.acuma.shuffler.tables.records.UserInfoRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserInfo extends TableImpl<UserInfoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_info</code>
     */
    public static final UserInfo USER_INFO = new UserInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserInfoRecord> getRecordType() {
        return UserInfoRecord.class;
    }

    /**
     * The column <code>public.user_info.telegram_id</code>.
     */
    public final TableField<UserInfoRecord, Long> TELEGRAM_ID = createField(DSL.name("telegram_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_info.language_code</code>.
     */
    public final TableField<UserInfoRecord, String> LANGUAGE_CODE = createField(DSL.name("language_code"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.user_info.is_bot</code>.
     */
    public final TableField<UserInfoRecord, Boolean> IS_BOT = createField(DSL.name("is_bot"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.user_info.first_name</code>.
     */
    public final TableField<UserInfoRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.user_info.last_name</code>.
     */
    public final TableField<UserInfoRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.user_info.user_name</code>.
     */
    public final TableField<UserInfoRecord, String> USER_NAME = createField(DSL.name("user_name"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.user_info.is_blocked</code>.
     */
    public final TableField<UserInfoRecord, Boolean> IS_BLOCKED = createField(DSL.name("is_blocked"), SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.user_info.last_message_at</code>.
     */
    public final TableField<UserInfoRecord, OffsetDateTime> LAST_MESSAGE_AT = createField(DSL.name("last_message_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>public.user_info.created_at</code>.
     */
    public final TableField<UserInfoRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "");

    /**
     * The column <code>public.user_info.updated_at</code>.
     */
    public final TableField<UserInfoRecord, OffsetDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>public.user_info.deleted_at</code>.
     */
    public final TableField<UserInfoRecord, OffsetDateTime> DELETED_AT = createField(DSL.name("deleted_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    private UserInfo(Name alias, Table<UserInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserInfo(Name alias, Table<UserInfoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_info</code> table reference
     */
    public UserInfo(String alias) {
        this(DSL.name(alias), USER_INFO);
    }

    /**
     * Create an aliased <code>public.user_info</code> table reference
     */
    public UserInfo(Name alias) {
        this(alias, USER_INFO);
    }

    /**
     * Create a <code>public.user_info</code> table reference
     */
    public UserInfo() {
        this(DSL.name("user_info"), null);
    }

    public <O extends Record> UserInfo(Table<O> child, ForeignKey<O, UserInfoRecord> key) {
        super(child, key, USER_INFO);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<UserInfoRecord> getPrimaryKey() {
        return Keys.USER_INFO_PKEY;
    }

    @Override
    public UserInfo as(String alias) {
        return new UserInfo(DSL.name(alias), this);
    }

    @Override
    public UserInfo as(Name alias) {
        return new UserInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserInfo rename(String name) {
        return new UserInfo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserInfo rename(Name name) {
        return new UserInfo(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, String, Boolean, String, String, String, Boolean, OffsetDateTime, OffsetDateTime, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}

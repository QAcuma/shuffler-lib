/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.acuma.shuffler.tables.GroupInfo;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupInfoRecord extends UpdatableRecordImpl<GroupInfoRecord> implements Record5<Long, String, Boolean, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.group_info.id</code>.
     */
    public GroupInfoRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.group_info.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.group_info.title</code>.
     */
    public GroupInfoRecord setTitle(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.group_info.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.group_info.is_active</code>.
     */
    public GroupInfoRecord setIsActive(Boolean value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.group_info.is_active</code>.
     */
    public Boolean getIsActive() {
        return (Boolean) get(2);
    }

    /**
     * Setter for <code>public.group_info.name</code>.
     */
    public GroupInfoRecord setName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.group_info.name</code>.
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.group_info.telegram_name</code>.
     */
    public GroupInfoRecord setTelegramName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.group_info.telegram_name</code>.
     */
    public String getTelegramName() {
        return (String) get(4);
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
    public Row5<Long, String, Boolean, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, String, Boolean, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return GroupInfo.GROUP_INFO.ID;
    }

    @Override
    public Field<String> field2() {
        return GroupInfo.GROUP_INFO.TITLE;
    }

    @Override
    public Field<Boolean> field3() {
        return GroupInfo.GROUP_INFO.IS_ACTIVE;
    }

    @Override
    public Field<String> field4() {
        return GroupInfo.GROUP_INFO.NAME;
    }

    @Override
    public Field<String> field5() {
        return GroupInfo.GROUP_INFO.TELEGRAM_NAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public Boolean component3() {
        return getIsActive();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public String component5() {
        return getTelegramName();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public Boolean value3() {
        return getIsActive();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public String value5() {
        return getTelegramName();
    }

    @Override
    public GroupInfoRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public GroupInfoRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public GroupInfoRecord value3(Boolean value) {
        setIsActive(value);
        return this;
    }

    @Override
    public GroupInfoRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public GroupInfoRecord value5(String value) {
        setTelegramName(value);
        return this;
    }

    @Override
    public GroupInfoRecord values(Long value1, String value2, Boolean value3, String value4, String value5) {
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
     * Create a detached GroupInfoRecord
     */
    public GroupInfoRecord() {
        super(GroupInfo.GROUP_INFO);
    }

    /**
     * Create a detached, initialised GroupInfoRecord
     */
    public GroupInfoRecord(Long id, String title, Boolean isActive, String name, String telegramName) {
        super(GroupInfo.GROUP_INFO);

        setId(id);
        setTitle(title);
        setIsActive(isActive);
        setName(name);
        setTelegramName(telegramName);
    }

    /**
     * Create a detached, initialised GroupInfoRecord
     */
    public GroupInfoRecord(ru.acuma.shuffler.tables.pojos.GroupInfo value) {
        super(GroupInfo.GROUP_INFO);

        if (value != null) {
            setId(value.getId());
            setTitle(value.getTitle());
            setIsActive(value.getIsActive());
            setName(value.getName());
            setTelegramName(value.getTelegramName());
        }
    }
}

/*
 * This file is generated by jOOQ.
 */
package ru.aplabs.ub.generated.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;

import ru.aplabs.ub.generated.tables.Settings;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.2",
        "schema version:1.001"
    },
    date = "2020-06-25T20:59:58.557Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SettingsRecord extends TableRecordImpl<SettingsRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 631943656;

    /**
     * Setter for <code>settings.name</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>settings.name</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>settings.value</code>.
     */
    public void setValue(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>settings.value</code>.
     */
    public String getValue() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Settings.SETTINGS.NAME;
    }

    @Override
    public Field<String> field2() {
        return Settings.SETTINGS.VALUE;
    }

    @Override
    public String component1() {
        return getName();
    }

    @Override
    public String component2() {
        return getValue();
    }

    @Override
    public String value1() {
        return getName();
    }

    @Override
    public String value2() {
        return getValue();
    }

    @Override
    public SettingsRecord value1(String value) {
        setName(value);
        return this;
    }

    @Override
    public SettingsRecord value2(String value) {
        setValue(value);
        return this;
    }

    @Override
    public SettingsRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SettingsRecord
     */
    public SettingsRecord() {
        super(Settings.SETTINGS);
    }

    /**
     * Create a detached, initialised SettingsRecord
     */
    public SettingsRecord(String name, String value) {
        super(Settings.SETTINGS);

        set(0, name);
        set(1, value);
    }
}

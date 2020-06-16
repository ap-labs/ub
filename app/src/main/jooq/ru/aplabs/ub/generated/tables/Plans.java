/*
 * This file is generated by jOOQ.
 */
package ru.aplabs.ub.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ru.aplabs.ub.generated.DefaultSchema;
import ru.aplabs.ub.generated.Keys;
import ru.aplabs.ub.generated.tables.records.PlansRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1",
        "schema version:1.001"
    },
    date = "2020-06-16T23:18:53.437Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Plans extends TableImpl<PlansRecord> {

    private static final long serialVersionUID = 1339034467;

    /**
     * The reference instance of <code>plans</code>
     */
    public static final Plans PLANS = new Plans();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PlansRecord> getRecordType() {
        return PlansRecord.class;
    }

    /**
     * The column <code>plans.id</code>.
     */
    public final TableField<PlansRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>plans.description</code>.
     */
    public final TableField<PlansRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB.nullable(false).defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>plans.price</code>.
     */
    public final TableField<PlansRecord, Long> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>plans.active</code>.
     */
    public final TableField<PlansRecord, Boolean> ACTIVE = createField(DSL.name("active"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>plans</code> table reference
     */
    public Plans() {
        this(DSL.name("plans"), null);
    }

    /**
     * Create an aliased <code>plans</code> table reference
     */
    public Plans(String alias) {
        this(DSL.name(alias), PLANS);
    }

    /**
     * Create an aliased <code>plans</code> table reference
     */
    public Plans(Name alias) {
        this(alias, PLANS);
    }

    private Plans(Name alias, Table<PlansRecord> aliased) {
        this(alias, aliased, null);
    }

    private Plans(Name alias, Table<PlansRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Plans(Table<O> child, ForeignKey<O, PlansRecord> key) {
        super(child, key, PLANS);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<PlansRecord> getPrimaryKey() {
        return Keys.PLANS_PKEY;
    }

    @Override
    public List<UniqueKey<PlansRecord>> getKeys() {
        return Arrays.<UniqueKey<PlansRecord>>asList(Keys.PLANS_PKEY);
    }

    @Override
    public Plans as(String alias) {
        return new Plans(DSL.name(alias), this);
    }

    @Override
    public Plans as(Name alias) {
        return new Plans(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Plans rename(String name) {
        return new Plans(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Plans rename(Name name) {
        return new Plans(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, Long, Boolean> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
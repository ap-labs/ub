/*
 * This file is generated by jOOQ.
 */
package ru.aplabs.ub.generated.tables.records;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import ru.aplabs.ub.generated.tables.Subscriptions;


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
public class SubscriptionsRecord extends UpdatableRecordImpl<SubscriptionsRecord> implements Record6<Long, String, String, Boolean, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = -366673788;

    /**
     * Setter for <code>subscriptions.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>subscriptions.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>subscriptions.account_id</code>.
     */
    public void setAccountId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>subscriptions.account_id</code>.
     */
    public String getAccountId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>subscriptions.plan_id</code>.
     */
    public void setPlanId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>subscriptions.plan_id</code>.
     */
    public String getPlanId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>subscriptions.deleted</code>.
     */
    public void setDeleted(Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>subscriptions.deleted</code>.
     */
    public Boolean getDeleted() {
        return (Boolean) get(3);
    }

    /**
     * Setter for <code>subscriptions.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>subscriptions.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>subscriptions.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>subscriptions.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, Boolean, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, String, String, Boolean, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Subscriptions.SUBSCRIPTIONS.ID;
    }

    @Override
    public Field<String> field2() {
        return Subscriptions.SUBSCRIPTIONS.ACCOUNT_ID;
    }

    @Override
    public Field<String> field3() {
        return Subscriptions.SUBSCRIPTIONS.PLAN_ID;
    }

    @Override
    public Field<Boolean> field4() {
        return Subscriptions.SUBSCRIPTIONS.DELETED;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Subscriptions.SUBSCRIPTIONS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Subscriptions.SUBSCRIPTIONS.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getAccountId();
    }

    @Override
    public String component3() {
        return getPlanId();
    }

    @Override
    public Boolean component4() {
        return getDeleted();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getAccountId();
    }

    @Override
    public String value3() {
        return getPlanId();
    }

    @Override
    public Boolean value4() {
        return getDeleted();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdatedAt();
    }

    @Override
    public SubscriptionsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public SubscriptionsRecord value2(String value) {
        setAccountId(value);
        return this;
    }

    @Override
    public SubscriptionsRecord value3(String value) {
        setPlanId(value);
        return this;
    }

    @Override
    public SubscriptionsRecord value4(Boolean value) {
        setDeleted(value);
        return this;
    }

    @Override
    public SubscriptionsRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SubscriptionsRecord value6(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public SubscriptionsRecord values(Long value1, String value2, String value3, Boolean value4, LocalDateTime value5, LocalDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SubscriptionsRecord
     */
    public SubscriptionsRecord() {
        super(Subscriptions.SUBSCRIPTIONS);
    }

    /**
     * Create a detached, initialised SubscriptionsRecord
     */
    public SubscriptionsRecord(Long id, String accountId, String planId, Boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Subscriptions.SUBSCRIPTIONS);

        set(0, id);
        set(1, accountId);
        set(2, planId);
        set(3, deleted);
        set(4, createdAt);
        set(5, updatedAt);
    }
}

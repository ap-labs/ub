/*
 * This file is generated by jOOQ.
 */
package ru.aplabs.ub.generated.tables.records;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ru.aplabs.ub.generated.tables.Payments;


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
public class PaymentsRecord extends UpdatableRecordImpl<PaymentsRecord> implements Record4<Long, Long, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1662035498;

    /**
     * Setter for <code>payments.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>payments.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>payments.subscription_id</code>.
     */
    public void setSubscriptionId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>payments.subscription_id</code>.
     */
    public Long getSubscriptionId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>payments.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>payments.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>payments.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>payments.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Long, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Payments.PAYMENTS.ID;
    }

    @Override
    public Field<Long> field2() {
        return Payments.PAYMENTS.SUBSCRIPTION_ID;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Payments.PAYMENTS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Payments.PAYMENTS.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getSubscriptionId();
    }

    @Override
    public LocalDateTime component3() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component4() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getSubscriptionId();
    }

    @Override
    public LocalDateTime value3() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value4() {
        return getUpdatedAt();
    }

    @Override
    public PaymentsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public PaymentsRecord value2(Long value) {
        setSubscriptionId(value);
        return this;
    }

    @Override
    public PaymentsRecord value3(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public PaymentsRecord value4(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public PaymentsRecord values(Long value1, Long value2, LocalDateTime value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PaymentsRecord
     */
    public PaymentsRecord() {
        super(Payments.PAYMENTS);
    }

    /**
     * Create a detached, initialised PaymentsRecord
     */
    public PaymentsRecord(Long id, Long subscriptionId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Payments.PAYMENTS);

        set(0, id);
        set(1, subscriptionId);
        set(2, createdAt);
        set(3, updatedAt);
    }
}

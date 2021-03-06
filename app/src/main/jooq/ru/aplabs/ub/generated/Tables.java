/*
 * This file is generated by jOOQ.
 */
package ru.aplabs.ub.generated;


import javax.annotation.Generated;

import ru.aplabs.ub.generated.tables.Accounts;
import ru.aplabs.ub.generated.tables.Payments;
import ru.aplabs.ub.generated.tables.Plans;
import ru.aplabs.ub.generated.tables.Settings;
import ru.aplabs.ub.generated.tables.Subscriptions;


/**
 * Convenience access to all tables in 
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
public class Tables {

    /**
     * The table <code>accounts</code>.
     */
    public static final Accounts ACCOUNTS = Accounts.ACCOUNTS;

    /**
     * The table <code>payments</code>.
     */
    public static final Payments PAYMENTS = Payments.PAYMENTS;

    /**
     * The table <code>plans</code>.
     */
    public static final Plans PLANS = Plans.PLANS;

    /**
     * The table <code>settings</code>.
     */
    public static final Settings SETTINGS = Settings.SETTINGS;

    /**
     * The table <code>subscriptions</code>.
     */
    public static final Subscriptions SUBSCRIPTIONS = Subscriptions.SUBSCRIPTIONS;
}

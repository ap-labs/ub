package ru.aplabs.ub.api;

import java.util.Collection;

public interface UB {

    void subscribe(Account account, Plan plan);

    void unsubscribe(Account account);

    Collection<Plan> plans();

    Collection<PaymentItem> history();
}

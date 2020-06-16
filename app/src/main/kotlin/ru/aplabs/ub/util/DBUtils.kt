package ru.aplabs.ub.util

import org.jooq.DSLContext
import org.jooq.Field
import org.jooq.Record
import org.jooq.Table

object DBUtils {

    fun <T : Record?, F> findExistingOrNew(ctx: DSLContext, t: Table<T>?, f: Field<F>, id: F?): T {
        return if (id == null) {
            ctx.newRecord(t)
        } else {
            ctx.selectFrom(t)
                    .where(f.eq(id))
                    .fetchOptional()
                    .orElseThrow { IllegalStateException("Failed to find record with specified id") }
        }
    }
}

package io.github.laziness_dev.common.config;

import io.github.laziness_dev.generator.Auditable;
import org.jooq.RecordContext;
import org.jooq.RecordListener;

import java.time.OffsetDateTime;


public class AuditRecordListener implements RecordListener {

    @Override
    public void insertStart(RecordContext ctx) {
        if(ctx.record() instanceof Auditable record) {
            OffsetDateTime now = OffsetDateTime.now();
            record.updateCreatedAt(now);
            record.updateModifiedAt(now);
        }
    }

    @Override
    public void updateStart(RecordContext ctx) {
        if (ctx.record() instanceof Auditable) {
            Auditable record = (Auditable) ctx.record();
            record.updateModifiedAt(OffsetDateTime.now());
        }
    }
}

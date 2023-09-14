package io.github.laziness_dev.generator;

import java.time.OffsetDateTime;

public interface Auditable {
    public OffsetDateTime createdAt();

    public void updateCreatedAt(OffsetDateTime value);

    public OffsetDateTime modifiedAt();

    public void updateModifiedAt(OffsetDateTime value);
}

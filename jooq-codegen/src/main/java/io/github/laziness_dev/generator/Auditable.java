package io.github.laziness_dev.generator;

import java.time.OffsetDateTime;

public interface Auditable<T> {
    public OffsetDateTime createdAt();

    public T updateCreatedAt(OffsetDateTime value);

    public OffsetDateTime modifiedAt();

    public T updateModifiedAt(OffsetDateTime value);
}

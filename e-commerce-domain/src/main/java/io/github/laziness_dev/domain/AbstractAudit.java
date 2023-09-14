package io.github.laziness_dev.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class AbstractAudit {
    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "MODIFIED_AT")
    private OffsetDateTime modifiedAt;

    public OffsetDateTime createdAt() {
        return createdAt;
    }

    public OffsetDateTime modifiedAt() {
        return modifiedAt;
    }

    public void updateCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void updateModifiedAt(OffsetDateTime updatedAt) {
        this.modifiedAt = updatedAt;
    }
}

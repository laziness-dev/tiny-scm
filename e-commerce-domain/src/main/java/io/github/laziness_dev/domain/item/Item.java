package io.github.laziness_dev.domain.item;

import io.github.laziness_dev.domain.AbstractAudit;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ITEMS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends AbstractAudit {
    private static final String ITEM_PREFIX = "itm_";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ITEM_IDENTIFIER")
    private String itemIdentifier;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @Builder
    public Item(String name, BigDecimal price) {
        this.itemIdentifier = ITEM_PREFIX + UUID.randomUUID();
        this.status = ItemStatus.init();
        this.name = name;
        this.price = price;
    }

    public String id() {
        return this.itemIdentifier;
    }

    public String identifier() {
        return this.itemIdentifier;
    }

    public String name() {
        return name;
    }

    public BigDecimal price() {
        return price;
    }

    public String status() {
        return this.status.name();
    }
}

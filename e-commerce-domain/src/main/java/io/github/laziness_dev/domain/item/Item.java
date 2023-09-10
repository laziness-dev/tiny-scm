package io.github.laziness_dev.domain.item;

import io.github.laziness_dev.common.support.UUIDGenerator;
import io.github.laziness_dev.domain.BaseAuditing;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseAuditing {
    private static final String ITEM_PREFIX = "itm_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemIdentifier;
    private String name;
    private BigDecimal price;

    @Builder
    public Item(String name, BigDecimal price) {
        this.itemIdentifier = UUIDGenerator.generateFromKey(name + createdAt());
        this.name = name;
        this.price = price;
    }

    public String id() {
        return this.itemIdentifier;
    }

    public String name() {
        return name;
    }

    public BigDecimal price() {
        return price;
    }
}

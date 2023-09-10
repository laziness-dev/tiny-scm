package io.github.laziness_dev.domain.item.command;

import io.github.laziness_dev.domain.item.Item;

import java.math.BigDecimal;
import java.util.List;

public class ItemCommand {
    public record RegisterItemRequest(
            String name,
            Long price
    ) {
        public Item toEntity() {
            return Item.builder()
                    .name(name)
                    .price(BigDecimal.valueOf(price))
                    .build();
        }
    }
}

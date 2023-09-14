package io.github.laziness_dev.domain.item;

import java.math.BigDecimal;

public class ItemCommand {
    public record RegisterRequest(
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

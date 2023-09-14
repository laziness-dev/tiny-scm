package io.github.laziness_dev.domain.item;

import java.time.OffsetDateTime;

public class ItemView {

    public record Default(
            String itemIdentifier,
            String itemName,
            String itemPrice,
            String status,
            OffsetDateTime createdAt,
            OffsetDateTime modifiedAt
    ) {
        public Default(Item item) {
            this(item.identifier(),
                    item.name(),
                    item.price().toString(),
                    item.status(),
                    item.createdAt(),
                    item.modifiedAt());
        }
    }
}

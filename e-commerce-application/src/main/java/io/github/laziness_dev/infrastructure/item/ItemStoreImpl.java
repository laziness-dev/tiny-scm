package io.github.laziness_dev.infrastructure.item;

import io.github.laziness_dev.domain.item.Item;
import io.github.laziness_dev.domain.item.ItemStore;
import jooq.jooq_dsl.tables.JItems;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
public class ItemStoreImpl implements ItemStore {
    private final DSLContext jooq;

    public ItemStoreImpl(DSLContext jooq) {
        this.jooq = jooq;
    }

    @Override
    public Item store(Item initItem) {
        jooq.insertInto(JItems.ITEMS)
                .set(JItems.ITEMS.ITEM_IDENTIFIER, initItem.identifier())
                .set(JItems.ITEMS.NAME, initItem.name())
                .set(JItems.ITEMS.PRICE, initItem.price())
                .set(JItems.ITEMS.STATUS, initItem.status())
                .execute();
        return initItem;
    }
}

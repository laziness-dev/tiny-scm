package io.github.laziness_dev.infrastructure.item;

import io.github.laziness_dev.domain.item.Item;
import io.github.laziness_dev.domain.item.ItemStore;
import jooq.jooq_dsl.tables.daos.ItemsDao;
import org.springframework.stereotype.Component;
import jooq.jooq_dsl.tables.pojos.JItems;

@Component
public class ItemStoreImpl implements ItemStore {
    private final ItemsDao itemsDao;

    public ItemStoreImpl(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    @Override
    public Item store(Item initItem) {
       JItems jItems = new JItems(null,
               null,
               null,
               initItem.identifier(),
               initItem.name(),
               initItem.price(),
               initItem.status()
       );

        itemsDao.insert(jItems);
        return initItem;
    }
}

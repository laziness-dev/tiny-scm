package io.github.laziness_dev.infrastructure.item;

import io.github.laziness_dev.domain.item.*;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemStore itemStore;

    public ItemServiceImpl(ItemStore itemStore) {
        this.itemStore = itemStore;
    }

    public ItemView.Default register(ItemCommand.RegisterRequest request) {
        Item initItem = request.toEntity();
        return new ItemView.Default(itemStore.store(initItem));
    }

    @Override
    public void changeOnSale(String itemIdentifier) {

    }

    @Override
    public void changeEndOfSale(String itemIdentifier) {

    }

    @Override
    public String retrieveItem(String itemIdentifier) {
        return null;
    }
}

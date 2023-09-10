package io.github.laziness_dev.infrastructure.item;

import io.github.laziness_dev.domain.item.Item;
import io.github.laziness_dev.domain.item.ItemService;
import io.github.laziness_dev.domain.item.ItemStore;
import io.github.laziness_dev.domain.item.command.ItemCommand;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemStore itemStore;

    public ItemServiceImpl(ItemStore itemStore) {
        this.itemStore = itemStore;
    }

    public String register(ItemCommand.RegisterItemRequest request) {
        Item initItem = request.toEntity();
        return itemStore.store(initItem)
                .id();
    }

    @Override
    public String register(String request) {
        return null;
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

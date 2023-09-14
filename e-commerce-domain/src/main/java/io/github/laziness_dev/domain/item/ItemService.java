package io.github.laziness_dev.domain.item;

public interface ItemService {
    ItemView.Default register(ItemCommand.RegisterRequest request);
    void changeOnSale(String itemIdentifier);
    void changeEndOfSale(String itemIdentifier);
    String retrieveItem(String itemIdentifier);
}

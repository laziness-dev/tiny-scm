package io.github.laziness_dev.domain.item;

public interface ItemService {
    String register(String request);
    void changeOnSale(String itemIdentifier);
    void changeEndOfSale(String itemIdentifier);
    String retrieveItem(String itemIdentifier);
}

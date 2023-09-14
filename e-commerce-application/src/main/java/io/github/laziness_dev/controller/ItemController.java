package io.github.laziness_dev.controller;

import io.github.laziness_dev.domain.item.ItemCommand;
import io.github.laziness_dev.domain.item.ItemService;
import io.github.laziness_dev.domain.item.ItemView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemView.Default> register(@RequestBody ItemCommand.RegisterRequest request) {
        return ResponseEntity.ok(itemService.register(request));
    }
}

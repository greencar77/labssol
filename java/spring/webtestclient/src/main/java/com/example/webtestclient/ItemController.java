package com.example.webtestclient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final Map<String, Item> items = new ConcurrentHashMap<>();

    public ItemController() {
        items.put("1", new Item("1", "Keyboard"));
        items.put("2", new Item("2", "Mouse"));
    }

    @GetMapping
    public Flux<Item> listItems() {
        return Flux.fromIterable(items.values());
    }

    @PutMapping("/{id}")
    public Mono<Item> updateItem(@PathVariable String id, @RequestBody ItemRequest request) {
        Item updated = new Item(id, request.getName());
        items.put(id, updated);
        return Mono.just(updated);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteItem(@PathVariable String id) {
        items.remove(id);
        return Mono.empty();
    }

    public static class ItemRequest {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

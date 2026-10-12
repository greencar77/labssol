package com.example.webtestclient;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

class ItemControllerTest {

    private final WebTestClient webTestClient = WebTestClient.bindToController(new ItemController())
            .build();

    @Test
    void shouldGetAllItems() {
        webTestClient.get()
                .uri("/items")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].id").isEqualTo("1")
                .jsonPath("$[0].name").isEqualTo("Keyboard")
                .jsonPath("$[1].id").isEqualTo("2")
                .jsonPath("$[1].name").isEqualTo("Mouse");
    }

    @Test
    void shouldUpdateItem() {
        webTestClient.put()
                .uri("/items/1")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"name\":\"Mechanical Keyboard\"}")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.name").isEqualTo("Mechanical Keyboard");
    }

    @Test
    void shouldDeleteItem() {
        webTestClient.delete()
                .uri("/items/2")
                .exchange()
                .expectStatus().isOk();
    }
}

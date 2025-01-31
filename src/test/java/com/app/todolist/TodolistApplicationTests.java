package com.app.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	private final WebTestClient webTestClient;

    TodolistApplicationTests(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    @Test
	void contextLoads() {
	}

	void testCreatedSuccess   (){

	}

}

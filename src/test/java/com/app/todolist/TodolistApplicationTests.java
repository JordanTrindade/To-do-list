package com.app.todolist;

import com.app.todolist.model.task.Tarefa;
import com.app.todolist.model.task.TarefaPrioridade;
import com.app.todolist.model.task.TarefaStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	private static final String TAREFAS_URI = "/tarefas";

	@Test
	void testCreatedSuccess() {
		Tarefa tarefa = createTestTarefa();

		webTestClient.post()
				.uri(TAREFAS_URI)
				.bodyValue(tarefa)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$.[0].titulo").isEqualTo(tarefa.getTitulo())
				.jsonPath("$.[0].descricao").isEqualTo(tarefa.getDescricao())
				.jsonPath("$.[0].prioridade").isEqualTo(tarefa.getPrioridade().toString())
				.jsonPath("$.[0].status").isEqualTo(tarefa.getStatus().toString());
	}

	private Tarefa createTestTarefa() {
		return new Tarefa(
				"tarefa 1",
				"descricao",
				TarefaPrioridade.integerToPrioridade(1),
				TarefaStatus.integerToTarefaStatus(2)
		);
	}
}
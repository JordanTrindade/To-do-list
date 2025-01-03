package com.app.todolist;

import com.app.todolist.model.task.Tarefa;
import com.app.todolist.model.task.TarefaPrioridade;
import com.app.todolist.model.task.TarefaStatus;
import com.app.todolist.model.task.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Profile("dev")
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);

	}
	@Component
	class DataLoader implements CommandLineRunner {

		private final TarefaRepository tarefaRepository;

		// Injeção via construtor
		public DataLoader(TarefaRepository tarefaRepository) {
			this.tarefaRepository = tarefaRepository;
		}

		@Override
		public void run(String... args) throws Exception {
			Tarefa tarefa = new Tarefa("Estudar", "Estudar as 19", TarefaPrioridade.ALTA, TarefaStatus.PENDENTE);
			tarefaRepository.save(tarefa); // Persistindo a pessoa no banco de dados
		}

	}
}

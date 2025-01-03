package com.app.todolist.model.dto;

import com.app.todolist.model.task.TarefaPrioridade;
import com.app.todolist.model.task.TarefaStatus;

public record TarefaDto (String titulo, String descricao, TarefaPrioridade prioridade, TarefaStatus status){}

package com.app.todolist.model.task;

import jakarta.persistence.Entity;

public enum TarefaStatus {
    CONCLUIDO("concluido"),
    PENDENTE("andamento"),
    CANCELADA("cancelada");

    private String descricao;

    TarefaStatus(String descricao){
        this.descricao = descricao;
    }
}

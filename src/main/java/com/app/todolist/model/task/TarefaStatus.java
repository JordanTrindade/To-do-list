package com.app.todolist.model.task;

import jakarta.persistence.Entity;

public enum TarefaStatus {
    CONCLUIDO(1,"concluido"),
    PENDENTE( 2,"andamento"),
    CANCELADA(3,"cancelada");

    private Integer id;
    private String descricao;

    TarefaStatus(Integer id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
}

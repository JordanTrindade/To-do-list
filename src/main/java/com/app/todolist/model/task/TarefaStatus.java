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

    public static TarefaStatus integerToTarefaStatus(Integer id){
        for(TarefaStatus tarefaStatus : TarefaStatus.values()){
            if(tarefaStatus.getId() == id){
                return tarefaStatus;
            }
        }
        return null;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

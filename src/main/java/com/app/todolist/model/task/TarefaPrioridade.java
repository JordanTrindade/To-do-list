package com.app.todolist.model.task;

public enum TarefaPrioridade {

        ALTA("Urgente"),
        MEDIA("Verifcar"),
        BAIXA("Fazer"),
        INDEFINIDA("Quando possivel");

        private String descricao;

    TarefaPrioridade(String descricao){
            this.descricao = descricao;
    }
}

package com.app.todolist.model.task;

public enum TarefaPrioridade {
        ALTA( "Urgente",1),
        MEDIA("Verifcar",2),
        BAIXA("Fazer",3),
        INDEFINIDA("Quando possivel",4);

        private String descricao;
        private Integer id;

    TarefaPrioridade(String descricao, int id){
            this.descricao = descricao;
            this.id = id;
    }

}

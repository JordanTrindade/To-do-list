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

   public static TarefaPrioridade integerToPrioridade(Integer id){
        for(TarefaPrioridade tarefa : TarefaPrioridade.values()){
            if(tarefa.getId() == id){
                return tarefa;
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

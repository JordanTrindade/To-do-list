package com.app.todolist.model.task;

import jakarta.persistence.*;
import org.apache.catalina.users.GenericRole;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    private TarefaPrioridade prioridade;

    @Enumerated(EnumType.ORDINAL)
    private TarefaStatus status;

    public Tarefa(){}

    public Tarefa(String titulo, String descricao, TarefaPrioridade prioridade, TarefaStatus status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TarefaPrioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(TarefaPrioridade prioridade) {
        this.prioridade = prioridade;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }
}

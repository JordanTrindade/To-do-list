package com.app.todolist.model.task.service;

import com.app.todolist.model.task.Tarefa;
import com.app.todolist.model.task.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> add(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return listarTodasTarefas();
    }

    public List<Tarefa> delete(Long id){
        Tarefa tarefaEncontrada = buscaTarefaPorId(id);
        tarefaRepository.delete(tarefaEncontrada);
        return listarTodasTarefas();
    }

    public Tarefa buscaTarefaPorId(Long id){
        return tarefaRepository.findById(id).
                orElseThrow(
                        ()-> new EntityNotFoundException(("Tarefa nao encontrada")));
    }

    public List<Tarefa> listarTodasTarefas(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("titulo").ascending());

        return tarefaRepository.findAll(sort);
    }
}

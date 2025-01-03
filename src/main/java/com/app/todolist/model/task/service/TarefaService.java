package com.app.todolist.model.task.service;

import com.app.todolist.model.task.Tarefa;
import com.app.todolist.model.task.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id){
        Tarefa tarefaEncontrada = buscaTarefaPorId(id);
        tarefaRepository.delete(tarefaEncontrada);
    }

    public List<Tarefa> buscarTodasTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa buscaTarefaPorId(Long id){
        return tarefaRepository.findById(id).
                orElseThrow(
                        ()-> new EntityNotFoundException(("Tarefa nao encontrada")));
    }
}

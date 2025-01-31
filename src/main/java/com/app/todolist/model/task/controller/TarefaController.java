package com.app.todolist.model.task.controller;

import com.app.todolist.model.dto.TarefaDto;
import com.app.todolist.model.task.Tarefa;
import com.app.todolist.model.task.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List <Tarefa>> buscaTodasTarefas(){
       List<Tarefa> tarefas = tarefaService.listarTodasTarefas();
       if(Objects.isNull(tarefas) || tarefas.isEmpty()){
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.ok().body(tarefas);
    }

    @PostMapping
    public ResponseEntity<List<Tarefa>> addTarefa(@Validated @RequestBody TarefaDto tarefaDto) {

        Tarefa tarefaSalva = new Tarefa(
                tarefaDto.titulo(),
                tarefaDto.descricao(),
                tarefaDto.prioridade(),
                tarefaDto.status()
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tarefaSalva.getId())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.add(tarefaSalva));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Tarefa>> DeletaTarefaPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tarefaService.delete(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id){
        Tarefa tarefa = tarefaService.buscaTarefaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(tarefa);
    }

}

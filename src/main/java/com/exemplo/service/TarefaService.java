package com.exemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.exemplo.model.Tarefa;
import com.exemplo.repository.TarefaRepository;
import java.util.List;

@Service
@Transactional

public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;
    
    public void criarTarefa(Tarefa tarefa) {
        tarefaRepository.criarTarefa(tarefa);
    }
    
    public void atualizarTarefa(Tarefa tarefa) {
        tarefaRepository.atualizarTarefa(tarefa);
    }
    
    public void excluirTarefa(Tarefa tarefa) {
        tarefaRepository.excluirTarefa(tarefa);
    }
    
    public Tarefa buscarTarefaPorId(Long id) {
        return tarefaRepository.buscarTarefaPorId(id);
    }
    
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.listarTarefas();
    }

    public List<Tarefa> listarTarefasPorProjeto(Long id) {
        return tarefaRepository.listarTarefasPorProjeto(id);
    }
}
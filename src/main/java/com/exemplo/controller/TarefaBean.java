package com.exemplo.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.exemplo.model.Projeto;
import com.exemplo.model.Tarefa;
import com.exemplo.service.TarefaService;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class TarefaBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @ManagedProperty(value = "#{projetoBean}")
    private ProjetoBean projetoBean;
    
    @ManagedProperty(value = "#{tarefaService}")
    private TarefaService tarefaService;
    
    private Tarefa tarefaSelecionada;
    private List<Tarefa> tarefas;
    
    @PostConstruct
    public void inicializar() { 
        if (tarefaService == null) {
            throw new IllegalStateException("TarefaService não foi injetado corretamente");
        }
        tarefaSelecionada = new Tarefa();
        tarefas = tarefaService.listarTarefas();
    }
    
    public String salvar() {
        Projeto projetoSelecionado = projetoBean.getProjetoSelecionado();
        tarefaSelecionada.setProjeto(projetoSelecionado);
        if (tarefaSelecionada.getId() == null) {
            tarefaService.criarTarefa(tarefaSelecionada);
        } else {
            tarefaService.atualizarTarefa(tarefaSelecionada);
        }
        tarefaSelecionada = new Tarefa();
        return projetoBean.visualizar(projetoSelecionado.getId());
    }
    
    public void excluir(Tarefa tarefa) {
        tarefaService.excluirTarefa(tarefa);
        Projeto projetoSelecionado = projetoBean.getProjetoSelecionado();
        projetoBean.visualizar(projetoSelecionado.getId());
    }
    
    public String novaTarefa() {
        tarefaSelecionada = new Tarefa();
        return "/views/tarefa/cadastroTarefa.xhtml?faces-redirect=true";
    }

    public String visualizar(Long tarefaId) {
        this.tarefaSelecionada = this.tarefaService.buscarTarefaPorId(tarefaId);
        return "/views/tarefa/visualizarTarefa.xhtml?faces-redirect=true";
    }

    public String editar(Long tarefaId) {
        this.tarefaSelecionada = this.tarefaService.buscarTarefaPorId(tarefaId);
        return "/views/tarefa/editarTarefa.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/views/projeto/listaProjetos.xhtml?faces-redirect=true";
    }

    public String retornar() {
        return "/views/projeto/visualizarProjeto.xhtml?faces-redirect=true";
    }
    
    public Tarefa getTarefaSelecionada() {
        return tarefaSelecionada;
    }
    
    public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }
    
    public List<Tarefa> getTarefas() {
        return tarefas;
    }
    
    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    public void setTarefaService(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public void setProjetoBean(ProjetoBean projetoBean) {
        this.projetoBean = projetoBean;
    }

}

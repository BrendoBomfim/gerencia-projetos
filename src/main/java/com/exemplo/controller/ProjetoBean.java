package com.exemplo.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.exemplo.model.Projeto;
import com.exemplo.model.Tarefa;
import com.exemplo.service.ProjetoService;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProjetoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{projetoService}")
    private ProjetoService projetoService;
    
    private Projeto projetoSelecionado;
    private List<Projeto> projetos;

    @PostConstruct
    public void inicializar() {
        if (projetoService == null) {
            throw new IllegalStateException("ProjetoService não foi injetado corretamente");
        }

        projetoSelecionado = new Projeto();
        projetos = projetoService.listarProjetos();
    }

    public String salvar() {

        if (projetoSelecionado.getTitulo() == null || projetoSelecionado.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("O título do projeto não pode ser nulo ou vazio");
        }

        if (projetoSelecionado.getId() == null) {
            projetoService.criarProjeto(projetoSelecionado);
        } else {
            projetoService.atualizarProjeto(projetoSelecionado);
        }

        this.projetoSelecionado = new Projeto();
        projetos = projetoService.listarProjetos();
        return "/views/projeto/listaProjetos.xhtml?faces-redirect=true";
    }

    public void excluir(Long projetoId) {
        projetoSelecionado = projetoService.buscarProjetoPorId(projetoId);
        projetoService.excluirProjeto(projetoSelecionado);
        projetoSelecionado = new Projeto();
        projetos = projetoService.listarProjetos();
    }

    public String novoProjeto() {
        this.projetoSelecionado = new Projeto();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("projetoSelecionado", projetoSelecionado);
        return "/views/projeto/cadastroProjeto.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "/views/projeto/listaProjetos.xhtml?faces-redirect=true";
    }

    public String visualizar(Long projetoId) {
        projetoSelecionado = projetoService.buscarProjetoPorId(projetoId);
        return "/views/projeto/visualizarProjeto.xhtml?faces-redirect=true";
    }

    public String editar(Long projetoId) {
        this.projetoSelecionado = this.projetoService.buscarProjetoPorId(projetoId);
        return "/views/projeto/editarProjeto.xhtml?faces-redirect=true";
    }

    public String retornar() {
        return "/views/projeto/listaProjetos.xhtml?faces-redirect=true";
    }

    public Projeto getProjetoSelecionado() {
        return this.projetoSelecionado;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void setProjetoService(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    public List<Tarefa> getTarefas(){
        return projetoSelecionado.getTarefas();
    }
    
}

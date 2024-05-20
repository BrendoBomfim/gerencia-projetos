package com.exemplo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAREFA")
public class Tarefa  implements Serializable {

    private static final long serialVersionUID = 2378486775L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column
    private String descricao;
    
    @Column(nullable = false)
    private String prioridade;
    
    @Column(name = "estimativa_horas")
    private Integer estimativaHoras;
    
    public Tarefa() {}
    
    public Tarefa(String titulo, String descricao, String prioridade, Integer estimativaHoras) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.estimativaHoras = estimativaHoras;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
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
    
    public String getPrioridade() {
        return prioridade;
    }
    
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
    public Integer getEstimativaHoras() {
        return estimativaHoras;
    }
    
    public void setEstimativaHoras(Integer estimativaHoras) {
        this.estimativaHoras = estimativaHoras;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "{" +
            "  id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", prioridade='" + getPrioridade() + "'" +
            ", estimativaHoras='" + getEstimativaHoras() + "'" +
            "}";
    }

}
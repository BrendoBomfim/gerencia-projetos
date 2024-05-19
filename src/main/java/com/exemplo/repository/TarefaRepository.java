package com.exemplo.repository;

import org.springframework.stereotype.Repository;
import com.exemplo.model.Tarefa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class TarefaRepository {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void criarTarefa(Tarefa tarefa) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tarefa);
    }
    
    public void atualizarTarefa(Tarefa tarefa) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tarefa);
    }
    
    public void excluirTarefa(Tarefa tarefa) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(tarefa);
    }
    
    public Tarefa buscarTarefaPorId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tarefa.class, id);
    }
    
    public List<Tarefa> listarTarefas() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Tarefa", Tarefa.class).list();
    }

    public List<Tarefa> listarTarefasPorProjeto(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session
            .createQuery("FROM Tarefa t WHERE t.projeto_id = :projeto_id", Tarefa.class)
            .setParameter("projeto_id", id).list();
    }
}
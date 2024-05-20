package com.exemplo.repository;

import com.exemplo.model.Projeto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjetoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Projeto> listarProjetos() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Projeto", Projeto.class).list();
    }

    public Projeto buscarProjetoPorId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Projeto.class, id);
    }

     public void criarProjeto(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.save(projeto);
    }
    
    public void atualizarProjeto(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.update(projeto);
    }
    
    public void excluirProjeto(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(projeto);
    }

}
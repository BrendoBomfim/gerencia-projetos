package com.exemplo.repository;

import com.exemplo.model.Projeto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProjetoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Projeto> listarProjetos() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Projeto> query = session.createQuery("from Projeto", Projeto.class);
        return query.getResultList();
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
        System.out.println(projeto);
        session.update(projeto);
    }
    
    public void excluirProjeto(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(projeto);
    }

}
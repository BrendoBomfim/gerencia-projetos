package com.exemplo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.model.Projeto;
import com.exemplo.repository.ProjetoRepository;

@Service
@Transactional
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;
    
    public List<Projeto> listarProjetos() {
        return projetoRepository.listarProjetos();
    }

     public Projeto buscarProjetoPorId(Long id) {
        return projetoRepository.buscarProjetoPorId(id);
    }

    public void excluirProjeto(Projeto projeto) {
        projetoRepository.excluirProjeto(projeto);
    }

    public void criarProjeto(Projeto projeto) {
        projetoRepository.criarProjeto(projeto);
    }

    public void atualizarProjeto(Projeto projeto) {
        projetoRepository.atualizarProjeto(projeto);
    }


}
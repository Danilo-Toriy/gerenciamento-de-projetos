package com.example.danilo.service;

import com.example.danilo.entity.Projeto;
import com.example.danilo.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> findAll(){
        return projetoRepository.findAll();
    }

    public Optional<Projeto> findById(Long id){
        return projetoRepository.findById(id);
    }

    public Projeto save(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    public void deleteById(Long id){
        projetoRepository.deleteById(id);
    }

    public Projeto update(Long id, Projeto projeto){
        Projeto novoProjeto = projetoRepository.findById(id).get();

        novoProjeto.setNome(projeto.getNome());
        novoProjeto.setDataInicio(projeto.getDataInicio());
        novoProjeto.setDataFim(projeto.getDataFim());

        return projetoRepository.save(novoProjeto);
    }
}

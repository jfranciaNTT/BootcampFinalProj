package com.nttdata.ministerio_educacao.service;

import com.nttdata.ministerio_educacao.model.Disciplina;
import com.nttdata.ministerio_educacao.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repo;

    public List<Disciplina> getAllDisciplinas() {
        return repo.findAll();
    }
}

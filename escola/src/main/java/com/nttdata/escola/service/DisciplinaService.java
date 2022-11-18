package com.nttdata.escola.service;

import com.nttdata.escola.model.Disciplina;
import com.nttdata.escola.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repo;

    public List<Disciplina> listAll() {
        return repo.findAll();
    }

    public void save(Disciplina disciplina) {
        repo.save(disciplina);
    }

    public Disciplina get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}

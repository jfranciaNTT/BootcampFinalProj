package com.nttdata.escola.service;

import com.nttdata.escola.model.Aula;
import com.nttdata.escola.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AulaRepository repo;

    public List<Aula> listAll() {
        return repo.findAll();
    }

    public void save(Aula aula) {
        repo.save(aula);
    }

    public Aula get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}

package com.nttdata.escola.service;

import com.nttdata.escola.model.Professor;
import com.nttdata.escola.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repo;

    public List<Professor> listAll() {
        return repo.findAll();
    }

    public void save(Professor professor) {
        repo.save(professor);
    }

    public Professor get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}

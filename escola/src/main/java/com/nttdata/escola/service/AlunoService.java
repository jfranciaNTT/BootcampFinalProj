package com.nttdata.escola.service;

import com.nttdata.escola.model.Aluno;
import com.nttdata.escola.repository.AlunoRepository;
import com.nttdata.escola.validatores.AlunoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoService  {

    @Autowired
    private AlunoRepository repo;

    @Autowired
    private AlunoValidator valid;

    public List<Aluno> listAll() {
        return repo.findAll();
    }

    public boolean save(Aluno aluno) {
        if (repo.findById(aluno.getNif()).isPresent())
        {
            return false;
        }
            repo.save(aluno);
            if (valid.validarAluno(aluno))
            {
                return true;
            }
            else
            {
                repo.delete(aluno);
                return false;
            }
    }

    public Aluno get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public boolean edit(Aluno aluno) {
        if (valid.validarAluno(aluno))
        {
            repo.save(aluno);
            return true;
        }
        else
        {
            return false;
        }
    }
}

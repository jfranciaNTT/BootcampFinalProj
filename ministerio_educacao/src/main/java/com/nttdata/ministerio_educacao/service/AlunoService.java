package com.nttdata.ministerio_educacao.service;

import com.nttdata.ministerio_educacao.model.Aluno;
import com.nttdata.ministerio_educacao.repository.AlunoRepository;
import com.nttdata.ministerio_educacao.validatores.AlunoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoValidator alunoValidator;

    @Autowired AlunoRepository repository;


    public void postAluno(Aluno aluno) {
        alunoValidator.validaAluno(aluno);
    }

    public Aluno validaAluno(Aluno aluno)
    {
        return alunoValidator.validaAluno(aluno);
    }

    public Aluno findById(Long nif) {
        return repository.findById(nif).get();
    }
}

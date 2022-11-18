package com.nttdata.ministerio_educacao.controller;

import com.nttdata.ministerio_educacao.model.Aluno;
import com.nttdata.ministerio_educacao.model.Disciplina;
import com.nttdata.ministerio_educacao.service.AlunoService;
import com.nttdata.ministerio_educacao.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private DisciplinaService disciplinaService;

    @RequestMapping(path = "/disciplina", method = RequestMethod.GET)
    public List<Disciplina> getAllDisciplinas(){
        return disciplinaService.getAllDisciplinas();
    }

   /* @RequestMapping(path = "/postAluno/{id}", method = RequestMethod.POST)
    public Aluno postAluno(@RequestBody Aluno aluno){
        return alunoService.postAluno(aluno);
    }*/

    @RequestMapping(path = "/getAluno/{id}", method = RequestMethod.GET)
    public Aluno validaAluno(@PathVariable Long id){
        return alunoService.validaAluno(alunoService.findById(id));
    }
}

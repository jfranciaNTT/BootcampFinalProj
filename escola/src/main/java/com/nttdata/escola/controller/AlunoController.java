package com.nttdata.escola.controller;

import com.nttdata.escola.model.Aluno;
import com.nttdata.escola.service.AlunoService;
import com.nttdata.escola.validatores.AlunoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @RequestMapping("/newAluno")
    public String showNewAlunoPage(Model model) {
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);

        return "new_aluno";
    }

    @RequestMapping(value = "/saveAluno", method = RequestMethod.POST)
    public String saveAluno(@ModelAttribute("aluno") Aluno aluno) {
        if (alunoService.save(aluno)) {
            return "redirect:/aluno";
        }
        else {
            return "new_aluno_invalido";
        }
    }

    @RequestMapping("/editAluno/{nif}")
    public ModelAndView showEditAlunoPage(@PathVariable(name = "nif") long nif) {
        ModelAndView mav = new ModelAndView("edit_aluno");
        Aluno aluno = alunoService.get(nif);
        mav.addObject("aluno", aluno);

        return mav;
    }

    @RequestMapping("/deleteAluno/{nif}")
    public String deleteAluno(@PathVariable(name = "nif") long nif) {
        alunoService.delete(nif);
        return "redirect:/aluno";
    }

    @RequestMapping("/aluno")
    public String viewAllAlunos(Model model) {
        List<Aluno> listProducts = alunoService.listAll();
        model.addAttribute("listAlunos", listProducts);

        return "index_aluno";
    }
}

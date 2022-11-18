package com.nttdata.escola.controller;

import com.nttdata.escola.model.Disciplina;
import com.nttdata.escola.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;


    @RequestMapping("/newDisciplina")
    public String showNewDisciplinaPage(Model model) {
        Disciplina disciplina = new Disciplina();
        model.addAttribute("disciplina", disciplina);

        return "new_disciplina";
    }

    @RequestMapping(value = "/saveDisciplina", method = RequestMethod.POST)
    public String saveDisciplina(@ModelAttribute("disciplina") Disciplina disciplina) {
        disciplinaService.save(disciplina);

        return "redirect:/disciplina";
    }

    @RequestMapping("/editDisciplina/{disciplinaId}")
    public ModelAndView showEditDisciplinaPage(@PathVariable(name = "disciplinaId") int id) {
        ModelAndView mav = new ModelAndView("edit_disciplina");
        Disciplina disciplina = disciplinaService.get(id);
        mav.addObject("disciplina", disciplina);

        return mav;
    }

    @RequestMapping("/deleteDisciplina/{disciplinaId}")
    public String deleteDisciplina(@PathVariable(name = "disciplinaId") int id) {
        disciplinaService.delete(id);
        return "redirect:/disciplina";
    }

    @RequestMapping("/disciplina")
    public String viewAllDisciplinas(Model model) {
        List<Disciplina> listDisciplinas = disciplinaService.listAll();
        model.addAttribute("listDisciplinas", listDisciplinas);

        return "index_disciplina";
    }
}

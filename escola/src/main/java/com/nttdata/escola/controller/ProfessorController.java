package com.nttdata.escola.controller;

import com.nttdata.escola.model.Professor;
import com.nttdata.escola.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @RequestMapping("/newProfessor")
    public String showNewProfessorPage(Model model) {
        Professor professor = new Professor();
        model.addAttribute("professor", professor);

        return "new_professor";
    }

    @RequestMapping(value = "/saveProfessor", method = RequestMethod.POST)
    public String saveProfessor(@ModelAttribute("professor") Professor professor) {
        professorService.save(professor);

        return "redirect:/professor";
    }

    @RequestMapping("/editProfessor/{nifProfessor}")
    public ModelAndView showEditProfessorPage(@PathVariable(name = "nifProfessor") long nif) {
        ModelAndView mav = new ModelAndView("edit_Professor");
        Professor professor = professorService.get(nif);
        mav.addObject("professor", professor);

        return mav;
    }

    @RequestMapping("/deleteProfessor/{nifProfessor}")
    public String deleteProfessor(@PathVariable(name = "nifProfessor") long nif) {
        professorService.delete(nif);
        return "redirect:/professor";
    }

    @RequestMapping("/professor")
    public String viewAllProfessor(Model model) {
        List<Professor> listProfessores = professorService.listAll();
        model.addAttribute("listProfessores", listProfessores);

        return "index_professor";
    }
}

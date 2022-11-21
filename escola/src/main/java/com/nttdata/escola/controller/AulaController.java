package com.nttdata.escola.controller;

import com.nttdata.escola.model.Aluno;
import com.nttdata.escola.model.Aula;
import com.nttdata.escola.model.Professor;
import com.nttdata.escola.service.AlunoService;
import com.nttdata.escola.service.AulaService;
import com.nttdata.escola.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private AlunoService alunoService;


    @RequestMapping("/newAula")
    public String showNewAulaPage(Model modelAula, Model modelProfessor, Model modelAluno) {
        Aula aula = new Aula();
        modelAula.addAttribute("aula", aula);
        List<Professor> professorList = professorService.listAll();
        modelProfessor.addAttribute("professorList", professorList);
        List<Aluno> alunoList = alunoService.listAll();
        modelAluno.addAttribute("alunoList", alunoList);
        return "new_aula";
    }

    @RequestMapping(value = "/saveAula", method = RequestMethod.POST)
    public String saveAula(@ModelAttribute("aula") Aula aula) {
        aulaService.save(aula);

        return "redirect:/aula";
    }

    @RequestMapping("/editAula/{aulaId}")
    public ModelAndView showEditAulaPage(@PathVariable(name = "aulaId") int id, Model modelProfessor, Model modelAluno) {
        ModelAndView mav = new ModelAndView("edit_aula");
        Aula aula = aulaService.get(id);
        mav.addObject("aula", aula);
        List<Professor> professorList = professorService.listAll();
        modelProfessor.addAttribute("professorList", professorList);
        List<Aluno> alunoList = alunoService.listAll();
        modelAluno.addAttribute("alunoList", alunoList);

        return mav;
    }

    @RequestMapping("/deleteAula/{aulaId}")
    public String deleteAula(@PathVariable(name = "aulaId") int id) {
        aulaService.delete(id);
        return "redirect:/aula";
    }

    @RequestMapping("/aula")
    public String viewAllAulas(Model model) {
        List<Aula> listAulas = aulaService.listAll();
        model.addAttribute("listAulas", listAulas);

        return "index_aula";
    }
}

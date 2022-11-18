package com.nttdata.escola.controller;

import com.nttdata.escola.model.Login;
import com.nttdata.escola.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String showLogin(Model model){
        Login login = new Login();
        model.addAttribute("login", login);
        return "login_page";
    }

    @GetMapping("/login")
    public String makeLogin(@ModelAttribute("username") Login login) {
        String page = "";
        if (loginService.findById(login.getUsername()).isPresent()
                && loginService.findById(login.getUsername()).get().getPass().equals(login.getPass())){
                return page = "homepage";
            }else {
            return "redirect:/";
        }
    }
}

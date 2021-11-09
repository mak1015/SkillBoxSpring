/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.web.controllers;


import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.app.services.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mak
 */

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    
    private Logger logger = Logger.getLogger(LoginController.class);
    private LoginService loginService;
    
    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    
    
    @GetMapping
    public String login(Model model){
        logger.info("GET /login returns login_page.html");
        model.addAttribute("loginForm",new LoginForm());
        return "login_page";
    }
    @PostMapping("/auth")
    public String authenticate(LoginForm loginform){
        if (loginService.authenticate(loginform)){
            return "redirect:/books/shelf";
        }else{
            return "redirect:/login";
        }
    }
}

package com.example.tabulasoftunispring.web;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login-error")
    public ModelAndView onLoginError(@ModelAttribute(UsernamePasswordAuthenticationFilter
            .SPRING_SECURITY_FORM_USERNAME_KEY) String email) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("login/login");
        modelAndView.addObject("username", email);
        modelAndView.addObject("error", "bad.credentials");

        return modelAndView;
    }

}

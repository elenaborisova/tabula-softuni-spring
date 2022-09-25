package com.example.tabulasoftunispring.web;

import com.example.tabulasoftunispring.models.dtos.RegistrationDto;
import com.example.tabulasoftunispring.models.entities.UserEntity;
import com.example.tabulasoftunispring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String showRegister(Model model) {
        model.addAttribute("formData", new RegistrationDto());
        return "registration/registration";
    }

    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute("formData") RegistrationDto registrationDto,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration/registration";
        }

        if (userService.existsUser(registrationDto.getEmail())) {
            bindingResult.rejectValue("email",
                    "error.email",
                    "Email already exists.");
            return "registration/registration";
        }

        userService.createAndLoginUser(registrationDto.getEmail(), registrationDto.getPassword());

        return "redirect:/home";
    }

}

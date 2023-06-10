package kz.alken1t.alex.firstsecurityapp.controllers;

import kz.alken1t.alex.firstsecurityapp.models.Person;
import kz.alken1t.alex.firstsecurityapp.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person")Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person")Person person){
        registrationService.register(person);
        return "redirect:/auth/login";
    }
}

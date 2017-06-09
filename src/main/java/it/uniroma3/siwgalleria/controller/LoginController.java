package it.uniroma3.siwgalleria.controller;

import it.uniroma3.siwgalleria.domain.Amministratore;
import it.uniroma3.siwgalleria.persistence.repository.AmministratoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marco on 09/06/2017.
 */
@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    AmministratoreRepository repository;


    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (repository.findByUsername("user") == null) {
            Amministratore admin = new Amministratore();
            admin.setUsername("user");
            admin.setPassword("pass");
            repository.save(admin);
        }


        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "admin/login";
    }



    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "admin/welcome";
    }

}

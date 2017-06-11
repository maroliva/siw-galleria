package it.uniroma3.siwgalleria.controller;

import it.uniroma3.siwgalleria.domain.Quadro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jerongeorge on 09/06/17.
 */
@Controller
@RequestMapping("/CrudOP")
public class QuadroController {

    @GetMapping("/inserimentoQuadro")
    public String formQuadro(Model model){
        model.addAttribute("quadro", new Quadro());
        return "inserimentoQuadro";
    }

    @PostMapping("/mostraQuadro")
    public String mostraQuadro(@ModelAttribute Quadro quadro){
        return "mostraQuadro";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

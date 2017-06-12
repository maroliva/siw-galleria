package it.uniroma3.siwgalleria.controller;
import it.uniroma3.siwgalleria.domain.Quadro;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

/**
 * Created by jerongeorge on 09/06/17.
 */
@Controller
@RequestMapping("/painting")
public class QuadroController {


    @GetMapping("/inserisciQuadro")
    public String formQuadro(Quadro quadro){
        return "inserimentoQuadro";
    }

    @PostMapping("/inserisciQuadro")
    public String mostraQuadro(@Valid Quadro quadro, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "inserimentoQuadro";
        return "mostraQuadro";
    }


}

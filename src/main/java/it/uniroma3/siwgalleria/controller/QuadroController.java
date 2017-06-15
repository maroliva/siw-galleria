package it.uniroma3.siwgalleria.controller;
import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.domain.Tecnica;
import it.uniroma3.siwgalleria.persistence.service.AutoreService;
import it.uniroma3.siwgalleria.persistence.service.QuadroService;
import it.uniroma3.siwgalleria.persistence.service.TecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by jerongeorge on 09/06/17.
 */
@Controller
@RequestMapping("/painting")
public class QuadroController {

    @Autowired
    private AutoreService autoreService;
    @Autowired
    private QuadroService quadroService;
    @Autowired
    private TecnicaService tecnicaService;

    @GetMapping("/inserisciQuadro")
    public String formQuadro(Model model){
        model.addAttribute("autori", autoreService.findAll());
        model.addAttribute("tecniche", tecnicaService.findAll());
        model.addAttribute("quadro",new Quadro());
        return "inserimentoQuadro";
    }

    @PostMapping("/inserisciQuadro")
    public String mostraQuadro(@Valid Quadro quadro, BindingResult bindingResult, HttpServletRequest request, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("autori", autoreService.findAll());
            model.addAttribute("tecniche", tecnicaService.findAll());
            return "inserimentoQuadro";
        }
        int idAutore=Integer.parseInt(request.getParameter("autore"));
        Autore autore=autoreService.findById(idAutore);
        quadro.setAutore(autore);
        int idTecnica=Integer.parseInt(request.getParameter("tecnica"));
        Tecnica tecnica=tecnicaService.findOne(idTecnica);
        quadro.setTecnica(tecnica);
        quadroService.save(quadro);
        return "mostraQuadro";
    }
}

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
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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

    @GetMapping("/save")
    public String formQuadro(Model model){
        model.addAttribute("autori", autoreService.findAll());
        model.addAttribute("tecniche", tecnicaService.findAll());
        model.addAttribute("quadro",new Quadro());
        return "admin/formSaveQuadro";
    }
    @PostMapping("/save")
    public String mostraQuadro(@Valid Quadro quadro, BindingResult bindingResult, @RequestParam long autore, @RequestParam long tecnica, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("autori", autoreService.findAll());
            model.addAttribute("tecniche", tecnicaService.findAll());
            return "admin/formSaveQuadro";
        }
        Autore a=autoreService.findById(autore);
        quadro.setAutore(a);
        Tecnica t=tecnicaService.findOne(tecnica);
        quadro.setTecnica(t);
        quadroService.save(quadro);
        return "admin/mostraQuadro";
    }

    @GetMapping("/update/{id}")
    public String modificaQuadro(@PathVariable long id, Model model){
        Quadro quadro=quadroService.findById(id);
        model.addAttribute("quadro",quadro);
        model.addAttribute("autori", autoreService.findAll());
        model.addAttribute("tecniche", tecnicaService.findAll());
        return "admin/formUpdateQuadro";
    }

    @PostMapping("/update")
    public String quadroModificato(@Valid Quadro quadro, BindingResult bindingResult, @RequestParam long autore, @RequestParam long tecnica, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("autori", autoreService.findAll());
            model.addAttribute("tecniche", tecnicaService.findAll());
            return "admin/formUpdateQuadro";
        }
        Autore a=autoreService.findById(autore);
        quadro.setAutore(a);
        Tecnica t=tecnicaService.findOne(tecnica);
        quadro.setTecnica(t);
        quadroService.save(quadro);
        model.addAttribute("quadri",quadroService.findAll());
        return "admin/welcome";
    }

    @GetMapping("/delete/{id}")
    public String cancellaQuadro(@PathVariable long id, Model model){
        Quadro quadro=quadroService.findById(id);
        quadroService.delete(id);
        model.addAttribute("quadri",quadroService.findAll());
        return "admin/welcome";
    }
}

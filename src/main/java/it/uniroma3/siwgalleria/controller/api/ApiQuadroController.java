package it.uniroma3.siwgalleria.controller.api;

import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.service.QuadroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by marco on 11/06/2017.
 */
@RestController
@RequestMapping("/api/quadri")
public class ApiQuadroController {

    @Autowired
    QuadroService service;

    @GetMapping(value = {"/",""}, produces = "application/json")
    @ResponseBody
    public List<Quadro> getQuadri() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Quadro getQuadro(@PathVariable String id) {
        if (id != null) {
            //TODO controlli sull'id
            Long idL = Long.parseLong(id);
            return service.findById(idL);
        }
        return null;

    }







}

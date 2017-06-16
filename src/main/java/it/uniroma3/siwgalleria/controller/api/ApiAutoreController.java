package it.uniroma3.siwgalleria.controller.api;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.persistence.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by marco on 12/06/2017.
 */
@RestController
@RequestMapping("/api/autori")
public class ApiAutoreController {

    @Autowired
    AutoreService service;

    @GetMapping(value = {"/",""}, produces = "application/json")
    @ResponseBody
    public List<Autore> getAutori() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Autore getAutore(@PathVariable String id) {
        if (id != null) {
            //TODO controlli sull'id
            Long idL = Long.parseLong(id);
            return service.findById(idL);
        }
        return null;

    }

}

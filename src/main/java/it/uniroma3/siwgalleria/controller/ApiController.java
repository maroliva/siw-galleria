package it.uniroma3.siwgalleria.controller;

import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.repository.QuadroRepository;
import it.uniroma3.siwgalleria.persistence.serivce.QuadroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by marco on 11/06/2017.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    QuadroService serivce;

    @RequestMapping(value = "/quadro", produces = "application/json")
    @ResponseBody
    public List<Quadro> getQuadri() {

        serivce.addQuadroTest();

        return serivce.findAll();
    }





}

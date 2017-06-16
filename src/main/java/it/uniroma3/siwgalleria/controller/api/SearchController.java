package it.uniroma3.siwgalleria.controller.api;

import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.service.QuadroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by marco on 16/06/2017.
 */
@Controller
@RequestMapping("/api/search")
public class SearchController {


    @Autowired
    QuadroService quadroService;

    @GetMapping
    @ResponseBody
    public List<Quadro> search(@RequestParam String key) {
        return quadroService.search(key);
    }




}

package it.uniroma3.siwgalleria.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by marco on 08/06/2017.
 */
@Controller
public class HomeController {

    @Value(value = "classpath:favicon.jpg")
    private Resource favicon;


    @GetMapping({"/",""})
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}

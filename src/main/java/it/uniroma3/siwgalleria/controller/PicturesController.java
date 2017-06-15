package it.uniroma3.siwgalleria.controller;

import it.uniroma3.siwgalleria.persistence.service.QuadroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by marco on 16/06/2017.
 */
@Controller
@RequestMapping("/pictures")
public class PicturesController {


    @Autowired
    QuadroService service;


    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPicture(@PathVariable String id) throws IOException {
        if (id != null) {
            //TODO controlli sull'id
            Long idL = Long.parseLong(id);
            return service.findById(idL).getPicture();
        }
        return null;

    }



}

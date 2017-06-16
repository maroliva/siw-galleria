package it.uniroma3.siwgalleria.controller;

import it.uniroma3.siwgalleria.persistence.service.QuadroService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by marco on 16/06/2017.
 */
@Controller
@RequestMapping("/pictures")
public class PicturesController implements ServletContextAware{


    @Autowired
    QuadroService service;

    ServletContext servletContext;


    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPicture(@PathVariable String id) throws IOException {
        if (id != null) {
            //TODO controlli sull'id
            Long idL = Long.parseLong(id);
            File file = new File(servletContext.getRealPath("/") + "/"
                    + "pictures/" + idL + ".jpg");

            return IOUtils.toByteArray(new FileInputStream(file));
        }
        return null;

    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

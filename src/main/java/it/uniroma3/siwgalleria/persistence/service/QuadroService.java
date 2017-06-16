package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.repository.AutoreRepository;
import it.uniroma3.siwgalleria.persistence.repository.QuadroRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
//poi magari cambio il nome dei metodi
@Service
public class QuadroService implements ServletContextAware{
    @Autowired
    private QuadroRepository quadroRepository;


    //TODO da eliminare è solo per un test
    @Autowired
    AutoreRepository autoreRepository;

    private ServletContext servletContext;

    public Quadro save(Quadro quadro){
        return quadroRepository.save(quadro);
    }


    public Quadro save(Quadro quadro, MultipartFile file) {
        Quadro quadroSaved = quadroRepository.save(quadro);
        String nameImage = String.valueOf(quadro.getId());
        saveImage(nameImage, file);

        quadroSaved.setPictureUrl("/pictures/" + nameImage);
        return quadroSaved;
    }


    public List<Quadro> findAll() {
        return quadroRepository.findAll();
    }

    @Value(value = "classpath:8d2b40fcc945bfa4505b172856f5a432.jpg")
    private Resource imageTest;

    public void addQuadroTest() throws IOException {

        Quadro quadro = new Quadro();
        quadro.setNome("Quadro Di Test");
        quadro.setAnno(10);

        Autore autore = new Autore();
        autore.setNome("NomeTest");
        autore.setCognome("CognomeTest");

        autoreRepository.save(autore);
        quadro.setAutore(autore);

        quadro = quadroRepository.save(quadro);

        String nameImage = String.valueOf(quadro.getId());
        saveImage(nameImage, IOUtils.toByteArray(imageTest.getInputStream()));

        quadro.setPictureUrl("/pictures/" + nameImage);
    }


    public Quadro findById(Long idL) {
        return quadroRepository.findById(idL);
    }



    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }


    private void saveImage(String filename, MultipartFile image) {
        File file = new File(servletContext.getRealPath("/") + "/pictures/"
                + filename + ".jpg");

        try {
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveImage(String filename, byte[] image) {
        File file = new File(servletContext.getRealPath("/") + "/pictures/"
                + filename + ".jpg");

        try {
            FileUtils.writeByteArrayToFile(file, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.domain.Tecnica;
import it.uniroma3.siwgalleria.persistence.repository.AutoreRepository;
import it.uniroma3.siwgalleria.persistence.repository.QuadroRepository;
import it.uniroma3.siwgalleria.persistence.repository.TecnicaRepository;
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
import java.util.LinkedList;
import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
//poi magari cambio il nome dei metodi
@Service
public class QuadroService implements ServletContextAware{
    @Autowired
    private QuadroRepository quadroRepository;

    @Autowired
    AutoreRepository autoreRepository;

    @Autowired
    TecnicaRepository tecnicaRepository;

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

    public Quadro findById(Long idL) {
        return quadroRepository.findById(idL);
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


    public List<Quadro> search(String allKeys) {
        String[] parts = allKeys.split("\\+");

        List<Quadro> out = new LinkedList<>();

        for (String part : parts) {
            Autore autore = autoreRepository.findByNome(part);
            Tecnica tecnica = tecnicaRepository.findByNome(part);

            out.addAll(quadroRepository.findByNomeOrTecnicaOrAutore(part,tecnica,autore));
        }

        return out;
    }




    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    //TODO da levare
    private void saveImage(String filename, byte[] image) {
        File file = new File(servletContext.getRealPath("/") + "/pictures/"
                + filename + ".jpg");

        try {
            FileUtils.writeByteArrayToFile(file, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO da levare
    @Value(value = "classpath:8d2b40fcc945bfa4505b172856f5a432.jpg")
    private Resource imageTest;

    //TODO da levare
    public void addQuadroTest() throws IOException {

        Quadro quadro = new Quadro();
        quadro.setNome("Quadro Di Test");
        quadro.setAnno(10);

        Autore autore = new Autore();
        autore.setNome("NomeTest");
        autore.setCognome("CognomeTest");

        if (autoreRepository.findByNome("NomeTest") == null)
            autoreRepository.save(autore);

        quadro.setAutore(autoreRepository.findByNome("NomeTest"));

        quadro = quadroRepository.save(quadro);

        String nameImage = String.valueOf(quadro.getId());
        saveImage(nameImage, IOUtils.toByteArray(imageTest.getInputStream()));

        quadro.setPictureUrl("/pictures/" + nameImage);
    }
}

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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    public void delete(long id){
        quadroRepository.delete(id);
    }
    public Quadro save(Quadro quadro){
        return quadroRepository.save(quadro);
    }

    public Quadro save(Quadro quadro, MultipartFile file) {
        Quadro quadroSaved = quadroRepository.save(quadro);
        String nameImage = String.valueOf(quadro.getId());
        saveImage(nameImage, file);

        quadroSaved.setPictureUrl("/pictures/" + nameImage);
        return quadroRepository.save(quadroSaved);

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
        String[] parts = allKeys.split("\\s");

        Set<Quadro> outSet = new HashSet<>();

        for (String part: parts) {
            //Cerco i quadri con questo autore per nome o per cognome
            List<Autore> autori = autoreRepository.findByNomeIgnoreCaseContaining(part);
            autori.addAll(autoreRepository.findByCognomeIgnoreCaseContaining(part));

            for (Autore autoreTrovato : autori) {
                outSet.addAll(quadroRepository.findByAutore(autoreTrovato));
            }

            //Cerco i quadri con questa tecnica
            List<Tecnica> tecniche = tecnicaRepository.findByNomeIgnoreCaseContaining(part);
            for (Tecnica tecnicaTrovata : tecniche) {
                outSet.addAll(quadroRepository.findByTecnica(tecnicaTrovata));
            }

            //Cerco i quadri con questo nome
            outSet.addAll(quadroRepository.findByNomeIgnoreCaseContaining(part));
        }

        List<Quadro> out = new LinkedList<>(outSet);
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
    private Resource imageTest1;

    @Value(value = "classpath:index.jpg")
    private Resource imageTest2;


    //TODO da levare
    public void addQuadriTest() throws IOException {

        Tecnica tecnica1 = new Tecnica();
        tecnica1.setNome("tecnica1");
        tecnica1.setDescrizione("tecnica1 descrizione");

        Tecnica tecnica2 = new Tecnica();
        tecnica2.setNome("tecnica2");
        tecnica2.setDescrizione("tecnica2 descrizione");

        tecnica1 = tecnicaRepository.save(tecnica1);
        tecnica2 = tecnicaRepository.save(tecnica2);

        Autore autore1 = new Autore();
        autore1.setNome("Autore1");
        autore1.setCognome("Congome autore1");

        Autore autore2 = new Autore();
        autore2.setNome("Autore2");
        autore2.setCognome("Congome autore2");

        autore1 = autoreRepository.save(autore1);
        autore2 = autoreRepository.save(autore2);


        Quadro quadro1 = new Quadro();
        quadro1.setNome("Test");
        quadro1.setAnno(10);
        quadro1.setAltezza(1.0);
        quadro1.setLarghezza(1.0);
        quadro1.setAutore(autore1);
        quadro1.setTecnica(tecnica1);

        quadro1 = quadroRepository.save(quadro1);
        String nameImage1 = String.valueOf(quadro1.getId());
        saveImage(nameImage1, IOUtils.toByteArray(imageTest1.getInputStream()));
        quadro1.setPictureUrl("/pictures/" + nameImage1);


        Quadro quadro2 = new Quadro();
        quadro2.setNome("Prova");
        quadro2.setAnno(11);
        quadro2.setAltezza(1.0);
        quadro2.setLarghezza(1.0);
        quadro2.setAutore(autore2);
        quadro2.setTecnica(tecnica2);

        quadro2 = quadroRepository.save(quadro2);
        String nameImage2 = String.valueOf(quadro2.getId());
        saveImage(nameImage2, IOUtils.toByteArray(imageTest2.getInputStream()));
        quadro2.setPictureUrl("/pictures/" + nameImage2);
    }


}

package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.repository.AutoreRepository;
import it.uniroma3.siwgalleria.persistence.repository.QuadroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
//poi magari cambio il nome dei metodi
@Service
public class QuadroService {
    @Autowired
    private QuadroRepository quadroRepository;


    //TODO da eliminare è solo per un test
    @Autowired
    AutoreRepository autoreRepository;

    public Quadro save(Quadro quadro){
        return quadroRepository.save(quadro);
    }

    public List<Quadro> findAll() {
        return quadroRepository.findAll();
    }

    public void addQuadroTest() {

        Quadro quadro = new Quadro();
        quadro.setNome("Quadro Di Test");
        quadro.setAnno(10);

        Autore autore = new Autore();
        autore.setNome("NomeTest");
        autore.setCognome("CognomeTest");

        autoreRepository.save(autore);
        quadro.setAutore(autore);

        quadroRepository.save(quadro);
    }


    public Quadro findById(Long idL) {
        return quadroRepository.findById(idL);
    }
}

package it.uniroma3.siwgalleria.persistence.serivce;

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
@Service
public class QuadroService {

    @Autowired
    QuadroRepository repository;

    //TODO da eliminare è solo per un test
    @Autowired
    AutoreRepository autoreRepository;

    public QuadroService() {
    }


    public List<Quadro> findAll() {
        return repository.findAll();
    }


    public void addQuadroTest() {

        Quadro quadro = new Quadro();
        quadro.setNome("Quadro Di Test");

        Autore autore = new Autore();
        autore.setNome("NomeTest");
        autore.setCognome("CognomeTest");

        autoreRepository.save(autore);
        quadro.setAutore(autore);

        repository.save(quadro);
    }
}

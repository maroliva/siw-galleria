package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.repository.QuadroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
//poi magari cambio il nome dei metodi
@Service
public class QuadroService {

    @Autowired
    QuadroRepository repository;

    @PersistenceContext
    EntityManager em;

    public List<Quadro> findAll() {
        return repository.findAll();
    }

    public Quadro findById(Long id) {
        return repository.findById(id);
    }

    public Quadro save(Quadro quadro){
            return repository.save(quadro);
    }

    public void delete(long id){
        repository.delete(id);
    }

    public QuadroService() {}
}



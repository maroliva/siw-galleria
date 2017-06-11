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

    public List<Quadro> findAll() {
        return repository.findAll();
    }

    public Quadro findById(Long id) {
        return repository.findById(id);
    }


    public QuadroService() {}
}

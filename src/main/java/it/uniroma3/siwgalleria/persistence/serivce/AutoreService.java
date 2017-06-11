package it.uniroma3.siwgalleria.persistence.serivce;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.persistence.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
@Service
public class AutoreService {

    @Autowired
    AutoreRepository repository;

    public Autore findById(Long id){
        return repository.findById(id);
    }

    public List<Autore> findAll() {
        return repository.findAll();
    }


    public AutoreService() {}
}

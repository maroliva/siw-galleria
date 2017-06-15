package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.persistence.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
//poi magari cambio il nome dei metodi
@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public Autore findById(long id){
        return autoreRepository.findOne(id);
    }

    public Autore save(Autore autore){
        return autoreRepository.save(autore);
    }

    public List<Autore> findAll(){
        return autoreRepository.findAll();
    }
}

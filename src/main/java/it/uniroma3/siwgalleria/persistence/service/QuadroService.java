package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.repository.QuadroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marco on 08/06/2017.
 */
//poi magari cambio il nome dei metodi
@Service
public class QuadroService {
    @Autowired
    private QuadroRepository quadroRepository;

    public Quadro save(Quadro quadro){
        return quadroRepository.save(quadro);
    }

}

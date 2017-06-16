package it.uniroma3.siwgalleria.persistence.service;
import it.uniroma3.siwgalleria.domain.Tecnica;
import it.uniroma3.siwgalleria.persistence.repository.TecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
@Service
public class TecnicaService {
    @Autowired
    private TecnicaRepository tecnicaRepository;

    public List<Tecnica> findAll(){
        return tecnicaRepository.findAll();
    }

    public Tecnica findOne(long id){
        return tecnicaRepository.findOne(id);
    }
}

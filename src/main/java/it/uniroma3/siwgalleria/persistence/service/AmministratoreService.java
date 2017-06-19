package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Amministratore;
import it.uniroma3.siwgalleria.persistence.repository.AmministratoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marco on 08/06/2017.
 */
@Service
public class AmministratoreService {

    @Autowired
    private AmministratoreRepository repository;

    public AmministratoreService() {
    }

    public Amministratore save(Amministratore entity) {
        return repository.save(entity);
    }
}

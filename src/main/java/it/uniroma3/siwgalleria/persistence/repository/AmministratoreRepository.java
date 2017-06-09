package it.uniroma3.siwgalleria.persistence.repository;

import it.uniroma3.siwgalleria.domain.Amministratore;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
public interface AmministratoreRepository extends CrudRepository<Amministratore, Long> {

    Amministratore save(Amministratore entity);

    List<Amministratore> findAll();

    void removeAmministratoreById(long id);

    Amministratore findByUsername(String username);
}

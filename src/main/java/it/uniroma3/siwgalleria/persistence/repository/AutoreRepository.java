package it.uniroma3.siwgalleria.persistence.repository;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
public interface AutoreRepository  extends CrudRepository<Autore, Long> {

    Autore save(Autore entity);

    List<Autore> findAll();

    void removeAutoreById(long id);

    Autore findById(long id);

    List<Autore> findByNomeIgnoreCaseContaining(String nome);

    List<Autore> findByCognomeIgnoreCaseContaining(String cognome);

}

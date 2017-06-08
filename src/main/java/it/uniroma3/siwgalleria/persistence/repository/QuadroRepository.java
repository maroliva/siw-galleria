package it.uniroma3.siwgalleria.persistence.repository;

import it.uniroma3.siwgalleria.domain.Quadro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
public interface QuadroRepository extends CrudRepository<Quadro, Long> {

    Quadro save(Quadro entity);

    List<Quadro> findAll();
}

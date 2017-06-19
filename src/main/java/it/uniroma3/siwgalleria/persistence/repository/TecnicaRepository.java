package it.uniroma3.siwgalleria.persistence.repository;

import it.uniroma3.siwgalleria.domain.Tecnica;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by jerongeorge on 14/06/17.
 */
public interface TecnicaRepository extends CrudRepository<Tecnica,Long> {

    Tecnica save(Tecnica entity);

    List<Tecnica> findAll();

    List<Tecnica> findByNomeIgnoreCaseContaining(String nome);
}

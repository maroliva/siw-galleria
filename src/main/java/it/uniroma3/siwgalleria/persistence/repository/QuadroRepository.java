package it.uniroma3.siwgalleria.persistence.repository;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.domain.Tecnica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by marco on 08/06/2017.
 */
@Transactional
public interface QuadroRepository extends CrudRepository<Quadro, Long> {

    Quadro save(Quadro entity);

    List<Quadro> findAll();

    void removeQuadroById(long id);

    List<Quadro> findByNome(String nome);

    Quadro findById(Long id);

    List<Quadro> findByAutore(Autore autore);

    List<Quadro> findByTecnica(Tecnica tecnica);


}

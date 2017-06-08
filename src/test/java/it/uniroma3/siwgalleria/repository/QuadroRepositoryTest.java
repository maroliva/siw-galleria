package it.uniroma3.siwgalleria.repository;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import it.uniroma3.siwgalleria.persistence.repository.AutoreRepository;
import it.uniroma3.siwgalleria.persistence.repository.QuadroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by marco on 08/06/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuadroRepositoryTest {

    @Autowired
    QuadroRepository quadroRepository;

    @Autowired
    AutoreRepository autoreRepository;

    @Test
    public void saveTest_inserimentoQuadroNelREpository() {
        Quadro quadro = new Quadro();
        quadro.setNome("Quadro Di Test");

        Autore autore = new Autore();
        autore.setNome("Nome autore di test");
        autore.setCognome("mannaggia a jerin e ai suoi constraint sul cognome");

        autoreRepository.save(autore);
        quadro.setAutore(autore);

        quadroRepository.save(quadro);
        assertTrue(quadroRepository.findAll().size() >= 1);
    }

}

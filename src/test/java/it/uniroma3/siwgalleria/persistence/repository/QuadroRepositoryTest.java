package it.uniroma3.siwgalleria.persistence.repository;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.domain.Quadro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
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
        autore.setNome("NomeTest");
        autore.setCognome("CognomeTest");

        autoreRepository.save(autore);
        quadro.setAutore(autore);

        quadroRepository.save(quadro);
        assertNotNull(quadroRepository.findByNomeIgnoreCaseContaining("Quadro Di Test"));
    }


    @Test
    public void saveTest_inserimentoQuadroNelRepository_senzaAggiungerePrimaIlSuoAutore_testCascade() {
        Quadro quadro = new Quadro();
        quadro.setNome("testCascade");

        Autore autore = new Autore();
        autore.setNome("nomeCascade");
        autore.setCognome("cognomeCascade");

        quadro.setAutore(autore);
        quadroRepository.save(quadro);

        assertNotNull(quadroRepository.findByNomeIgnoreCaseContaining("testCascade"));
    }


}

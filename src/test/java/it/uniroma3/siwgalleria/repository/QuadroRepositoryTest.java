package it.uniroma3.siwgalleria.repository;

import it.uniroma3.siwgalleria.domain.Quadro;
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
    QuadroRepository repository;

    @Test
    public void saveTest_inserimentoQuadroNelREpository() {
        repository.save(new Quadro());
        assertTrue(repository.findAll().size() >= 1);
    }

}

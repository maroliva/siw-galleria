package it.uniroma3.siwgalleria.repository;

import it.uniroma3.siwgalleria.domain.Autore;
import it.uniroma3.siwgalleria.persistence.repository.AutoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by marco on 08/06/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AutoreRepositoryTest {


    @Autowired
    private AutoreRepository repository;

    @Test
    public void saveTest_inserimentoDinUnAutore() {
        Autore autore = new Autore();
        autore.setNome("NomeTest");
        autore.setCognome("CognomeTest");

        repository.save(autore);

        assertTrue(repository.findAll().size() >= 1);
    }


}

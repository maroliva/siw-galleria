package it.uniroma3.siwgalleria.persistence.repository;

import it.uniroma3.siwgalleria.domain.Amministratore;
import it.uniroma3.siwgalleria.persistence.repository.AmministratoreRepository;
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
public class AmministratoreRepositoryTest {

    @Autowired
    private AmministratoreRepository repository;

    @Test
    public void saveTest_inserimentoDinUnAmministratore() {
        Amministratore amministratore = new Amministratore();
        amministratore.setUsername("NomeTest");
        amministratore.setPassword("PasswordTest");

        repository.save(amministratore);

        assertTrue(repository.findAll().size() >= 1);
    }
}

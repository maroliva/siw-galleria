package it.uniroma3.siwgalleria.persistence.service;

import it.uniroma3.siwgalleria.domain.Amministratore;
import it.uniroma3.siwgalleria.persistence.serivce.AmministratoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

/**
 * Created by marco on 09/06/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AmministratoreServiceTest {

    @Autowired
    private AmministratoreService service;


    @Test
    public void autenticaTest() {
        String username = "autenticazioneTestUsername";
        String password = "autenticazioneTestPassword";
        Amministratore amministratore = new Amministratore();
        amministratore.setUsername(username);
        amministratore.setPassword(password);

        service.save(amministratore);

        assertTrue(service.autentica(username,password));
    }



}

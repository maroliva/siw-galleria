package it.uniroma3.siwgalleria.domain;

import javax.persistence.*;

@Entity
public class Nazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeNazione;

    public Nazione() {
    }

    public long getId() {
        return id;
    }

    public String getNomeNazione() {
        return nomeNazione;
    }

    public void setNomeNazione(String nomeNazione) {
        this.nomeNazione = nomeNazione;
    }

}

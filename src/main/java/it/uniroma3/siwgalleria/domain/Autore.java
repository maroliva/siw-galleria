package it.uniroma3.siwgalleria.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;
    @Temporal(TemporalType.DATE)
    private Date dataDiMorte;
    @OneToMany(mappedBy = "autore")
    private List<Quadro> quadri;

    public Autore(){
        this.quadri=new ArrayList<>();
    }


    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Date getDataDiMorte() {
        return dataDiMorte;
    }

    public void setDataDiMorte(Date dataDiMorte) {
        this.dataDiMorte = dataDiMorte;
    }
}

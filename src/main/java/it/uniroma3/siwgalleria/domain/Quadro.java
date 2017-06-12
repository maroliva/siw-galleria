package it.uniroma3.siwgalleria.domain;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Quadro {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotBlank
    private String nome;
    @Min(1) //valutare poi se cambiare il valore di @Min
    private int anno;
    private double altezza;
    private double larghezza;
    @ManyToOne
    private Autore autore;
    @OneToOne
    private Tecnica tecnica;

    public Quadro(){}

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }

    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }
        public void setId(long id) {
        this.id = id;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }
}

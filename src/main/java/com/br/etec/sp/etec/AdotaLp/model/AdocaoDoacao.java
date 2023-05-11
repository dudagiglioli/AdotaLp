package com.br.etec.sp.etec.AdotaLp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "adocaodoacao")
public class AdocaoDoacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdocaoDoacao that = (AdocaoDoacao) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

  //---------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "iddoador")
    private AdotanteDoador doador;

    public AdotanteDoador getDoador() {
        return doador;
    }

    public void setDoador(AdotanteDoador doador) {
        this.doador = doador;
    }

    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idadotante")
    private AdotanteDoador adotante;

    public AdotanteDoador getAdotante() {
        return adotante;
    }

    public void setAdotante(AdotanteDoador adotante) {
        this.adotante = adotante;
    }

}

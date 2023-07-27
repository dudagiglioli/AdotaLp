package com.br.etec.sp.etec.AdotaLp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "adocaodoacao")
public class AdocaoDoacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataadocao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataadocao() {
        return dataadocao;
    }

    public void setDataadocao(LocalDate dataadocao) {
        this.dataadocao = dataadocao;
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
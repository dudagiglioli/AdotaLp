package com.br.etec.sp.etec.AdotaLp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "raca")
public class Raca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raca raca = (Raca) o;
        return id.equals(raca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "raca")
    private List<Animal> racaanimal = new ArrayList<>();

    public List<Animal> getRacaanimal() {
        return racaanimal;
    }

    public void setRacaanimal(List<Animal> racaanimal) {
        this.racaanimal = racaanimal;
    }

//--------------------------------------------------------------------------------------------------------------
}

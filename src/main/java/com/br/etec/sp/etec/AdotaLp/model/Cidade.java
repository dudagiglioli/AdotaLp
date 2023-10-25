package com.br.etec.sp.etec.AdotaLp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomecidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //--------------------------------------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idestado")
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "cidade")
    private List<AdotanteDoador> cidadeaotantedoador = new ArrayList<>();

    public List<AdotanteDoador> getCidadeaotantedoador() {
        return cidadeaotantedoador;
    }

    public void setCidadeaotantedoador(List<AdotanteDoador> cidadeaotantedoador) {
        this.cidadeaotantedoador = cidadeaotantedoador;
    }

    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "cidadedoanimal")
    private List<Animal> cidadedoanimal= new ArrayList<>();

    public List<Animal> getCidadedoanimal() {
        return cidadedoanimal;
    }

    public void setCidadedoanimal(List<Animal> cidadedoanimal) {
        this.cidadedoanimal = cidadedoanimal;
    }
}
package com.br.etec.sp.etec.AdotaLp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeestado;
    private String sigla;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeestado() {
        return nomeestado;
    }

    public void setNomeestado(String nomeestado) {
        this.nomeestado = nomeestado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id.equals(estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidadeestado = new ArrayList<>();

    public List<Cidade> getCidadeestado() {
        return cidadeestado;
    }

    public void setCidadeestado(List<Cidade> cidadeestado) {
        this.cidadeestado = cidadeestado;
    }

    //--------------------------------------------------------------------------------------------------------------

}
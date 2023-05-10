package com.br.etec.sp.etec.AdotaLp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "situacaoanimal")
public class SituacaoAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String situacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SituacaoAnimal that = (SituacaoAnimal) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //--------------------------------------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal situacaoanimal;

    public Animal getSituacaoanimal() {
        return situacaoanimal;
    }

    public void setSituacaoanimal(Animal situacaoanimal) {
        this.situacaoanimal = situacaoanimal;
    }

    //--------------------------------------------------------------------------------------------------------------

    
}

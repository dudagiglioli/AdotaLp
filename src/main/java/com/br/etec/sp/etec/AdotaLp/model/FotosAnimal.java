package com.br.etec.sp.etec.AdotaLp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fotosanimal")
public class FotosAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String fotoa;
    private String fotob;
    private String fotoc;
    private String fotod;
    private String fotoe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFotoa() {
        return fotoa;
    }

    public void setFotoa(String fotoa) {
        this.fotoa = fotoa;
    }

    public String getFotob() {
        return fotob;
    }

    public void setFotob(String fotob) {
        this.fotob = fotob;
    }

    public String getFotoc() {
        return fotoc;
    }

    public void setFotoc(String fotoc) {
        this.fotoc = fotoc;
    }

    public String getFotod() {
        return fotod;
    }

    public void setFotod(String fotod) {
        this.fotod = fotod;
    }

    public String getFotoe() {
        return fotoe;
    }

    public void setFotoe(String fotoe) {
        this.fotoe = fotoe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotosAnimal that = (FotosAnimal) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //--------------------------------------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal fotosanimal;

    public Animal getFotosanimal() { return fotosanimal; }

    public void setFotosanimal(Animal fotosanimal) { this.fotosanimal = fotosanimal; }

}

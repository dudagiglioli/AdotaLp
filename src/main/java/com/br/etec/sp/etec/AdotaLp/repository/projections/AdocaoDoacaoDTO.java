package com.br.etec.sp.etec.AdotaLp.repository.projections;

import java.time.LocalDate;

public class AdocaoDoacaoDTO {

    private Integer id;
    private LocalDate dataadocao;
    private String nomeanimal;
    private String nomeadotante;
    private String nomedoador;

    public AdocaoDoacaoDTO(Integer id, LocalDate dataadocao, String nomeanimal, String nomeadotante, String nomedoador) {
        this.id = id;
        this.dataadocao = dataadocao;
        this.nomeanimal = nomeanimal;
        this.nomeadotante = nomeadotante;
        this.nomedoador = nomedoador;
    }

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

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }

    public String getNomeadotante() {
        return nomeadotante;
    }

    public void setNomeadotante(String nomeadotante) {
        this.nomeadotante = nomeadotante;
    }

    public String getNomedoador() {
        return nomedoador;
    }

    public void setNomedoador(String nomedoador) {
        this.nomedoador = nomedoador;
    }
}

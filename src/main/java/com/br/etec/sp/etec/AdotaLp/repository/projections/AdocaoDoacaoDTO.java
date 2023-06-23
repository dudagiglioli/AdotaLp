package com.br.etec.sp.etec.AdotaLp.repository.projections;

import java.time.LocalDate;

public class AdocaoDoacaoDTO {

    private Integer id;
    private LocalDate dataadocao;
    private String nomeanimal;
    private String raca;
    private String nomeadotante;
    private String nomedoador;
    private String nomecidade;
    private String noomeestado;

    public AdocaoDoacaoDTO(Integer id, LocalDate dataadocao, String nomeanimal, String raca, String nomeadotante, String nomedoador, String nomecidade, String noomeestado) {
        this.id = id;
        this.dataadocao = dataadocao;
        this.nomeanimal = nomeanimal;
        this.raca = raca;
        this.nomeadotante = nomeadotante;
        this.nomedoador = nomedoador;
        this.nomecidade = nomecidade;
        this.noomeestado = noomeestado;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
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

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getNoomeestado() {
        return noomeestado;
    }

    public void setNoomeestado(String noomeestado) {
        this.noomeestado = noomeestado;
    }
}

package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class CidadeDTO {

    private Integer id;
    private String nome;
    private String nomestado;
    private String sigla;


    public CidadeDTO(Integer id, String nome, String nomestado, String sigla) {
        this.id = id;
        this.nome = nome;
        this.nomestado = nomestado;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomestado() {
        return nomestado;
    }

    public void setNomestado(String nomestado) {
        this.nomestado = nomestado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class CidadeDTO {

    private Integer id;
    private String nomecidade;
    private String nomeestado;
    private String sigla;

    public CidadeDTO(Integer id, String nomecidade, String nomeestado, String sigla) {
        this.id = id;
        this.nomecidade = nomecidade;
        this.nomeestado = nomeestado;
        this.sigla = sigla;
    }

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
}

package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class SituacaoAnimalDTO {

    private Integer id;
    private String situacao;
    private String nomeanimal;

    public SituacaoAnimalDTO(Integer id, String situacao, String nomeanimal) {
        this.id = id;
        this.situacao = situacao;
        this.nomeanimal = nomeanimal;
    }

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

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }
}

package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class SituacaoAnimalDTO {

    private String id;
    private String situacao;
    private String nomeanimal;

    public SituacaoAnimalDTO(String id, String situacao, String nomeanimal) {
        this.id = id;
        this.situacao = situacao;
        this.nomeanimal = nomeanimal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

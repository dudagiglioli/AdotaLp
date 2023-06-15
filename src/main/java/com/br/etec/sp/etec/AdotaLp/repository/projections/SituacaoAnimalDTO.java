package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class SituacaoAnimalDTO {

    private String situacao;
    private String nomeanimal;

    public SituacaoAnimalDTO(String situacao, String nomeanimal) {
        this.situacao = situacao;
        this.nomeanimal = nomeanimal;
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

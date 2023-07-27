package com.br.etec.sp.etec.AdotaLp.repository.filter;

public class AnimalFilter {

    private String nomeanimal;
    private String sexo;
    private Integer idade;
    private Integer porte;

    //FK's
    private String descricaoraca;
    private String situacaoanimal;
    private String nomecidade;
    private String nomeestado;


    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getPorte() {
        return porte;
    }

    public void setPorte(Integer porte) {
        this.porte = porte;
    }

    public String getDescricaoraca() {
        return descricaoraca;
    }

    public void setDescricaoraca(String descricaoraca) {
        this.descricaoraca = descricaoraca;
    }

    public String getSituacaoanimal() {
        return situacaoanimal;
    }

    public void setSituacaoanimal(String situacaoanimal) {
        this.situacaoanimal = situacaoanimal;
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
}

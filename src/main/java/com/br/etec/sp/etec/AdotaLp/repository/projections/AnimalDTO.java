package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class AnimalDTO {

    private Integer id;
    private String nomeanimal;
    private String sexo;
    private Integer idade;
    private Integer porte;
    //FK's
    private String descricao;
    private String situacaoanimal;
    private String nomecidade;


    public AnimalDTO(Integer id, String nomeanimal, String sexo, Integer idade, Integer porte, String descricao, String situacaoanimal, String nomecidade) {
        this.id = id;
        this.nomeanimal = nomeanimal;
        this.sexo = sexo;
        this.idade = idade;
        this.porte = porte;
        this.descricao = descricao;
        this.situacaoanimal = situacaoanimal;
        this.nomecidade = nomecidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}

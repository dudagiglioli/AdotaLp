package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class AnimalDTO {

    private Integer id;
    private String nome;
    private String sexo;
    private Integer idade;
    private Integer porte;
    private String descricaoraca;
    private String situacaoanimal;
    private String nomecidade;
    private String nomeestado;

    public AnimalDTO(Integer id, String nome, String sexo, Integer idade, Integer porte, String descricaoraca, String situacaoanimal, String nomecidade, String nomeestado) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.porte = porte;
        this.descricaoraca = descricaoraca;
        this.situacaoanimal = situacaoanimal;
        this.nomecidade = nomecidade;
        this.nomeestado = nomeestado;
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

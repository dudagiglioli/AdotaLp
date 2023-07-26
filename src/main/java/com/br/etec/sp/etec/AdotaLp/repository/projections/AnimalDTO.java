package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class AnimalDTO {

    private Integer id;
    private String nome;
    private String sexo;
    private Integer idade;
    private Integer porte;
    private String descricao;
    private String situacao;
    private String nomecidade;
    private String nomeestado;

  public AnimalDTO(Integer id, String nome, String sexo, Integer idade, Integer porte, String descricao, String situacao, String nomecidade, String nomeestado) {
    this.id = id;
    this.nome = nome;
    this.sexo = sexo;
    this.idade = idade;
    this.porte = porte;
    this.descricao = descricao;
    this.situacao = situacao;
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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(String situacao) {
    this.situacao = situacao;
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

package com.br.etec.sp.etec.AdotaLp.repository.filter;

public class AnimalFilter {

    private String nome;
    private String sexo;
    private Integer idade;
    private Integer porte;

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

}

package com.br.etec.sp.etec.AdotaLp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adotantedoador")
public class AdotanteDoador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Date dtnascimento;
    private String endereco;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdotanteDoador that = (AdotanteDoador) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //--------------------------------------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idcidade")
    private Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "doador")
    private List<AdocaoDoacao> doadordoacao = new ArrayList<>();

    public List<AdocaoDoacao> getDoadordoacao() {
        return doadordoacao;
    }

    public void setDoadordoacao(List<AdocaoDoacao> doadordoacao) {
        this.doadordoacao = doadordoacao;
    }

    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "adotante")
    private List<AdocaoDoacao> adotanteadocao = new ArrayList<>();

    public List<AdocaoDoacao> getAdotanteadocao() {
        return adotanteadocao;
    }

    public void setAdotanteadocao(List<AdocaoDoacao> adotanteadocao) {
        this.adotanteadocao = adotanteadocao;
    }

    //--------------------------------------------------------------------------------------------------------------
}

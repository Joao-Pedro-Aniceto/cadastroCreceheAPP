package com.exemplo.app;

public class Evento {

    private long id;
    private String nome, nomeCrianca, cpf, senha;


    public Evento(long id, String nome, String nomeCrianca, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.nomeCrianca = nomeCrianca;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Evento(String nome, String nomeCrianca, String cpf, String senha) {
        this.nome = nome;
        this.nomeCrianca = nomeCrianca;
        this.cpf = cpf;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCrianca() {
        return nomeCrianca;
    }

    public void setNomeCrianca(String nomeCrianca) {
        this.nomeCrianca = nomeCrianca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

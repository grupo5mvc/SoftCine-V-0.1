package com.grupo5.softCine.dominio;

public class Cliente {

    private Integer cod_cliente;
    private String nome;
    private String login;
    private String senha;
    private String email;


    public Cliente(int cod_cliente, String nome, String login, String senha, String email) {
        this.cod_cliente = cod_cliente;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Cliente(String nome, String login, String senha, String email) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Cliente() {
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

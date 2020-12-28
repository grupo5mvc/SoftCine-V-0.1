package com.grupo5.softCine.dominio;

public class Cinema {

    private Integer cod_cinema;
    private String nome;
    private String cnpj;


    public Cinema(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Cinema(int cod_cinema,String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cod_cinema = cod_cinema;
    }

    public Cinema(int cod_cinema) {
        this.cod_cinema=cod_cinema;
    }

    public Cinema() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getCod_cinema() {
        return cod_cinema;
    }

    public void setCod_cinema(Integer cod_cinema) {
        this.cod_cinema = cod_cinema;
    }
}

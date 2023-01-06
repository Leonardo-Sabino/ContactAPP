package com.example.contactapp;

public class Contatos {

    private String nome;
    private int numero;
    private String email;
    private  String foto;

    //funcao
    public Contatos(String nome, int numero, String email,String foto) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.foto = foto;
    }
    //ele concantena todos os Strings
    @Override
    public String toString() {
        return "Contatos{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                ", email='" + email + '\'' +
                '}';
    }
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }
}

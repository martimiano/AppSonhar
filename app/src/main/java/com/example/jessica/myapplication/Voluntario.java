package com.example.jessica.myapplication;

public class Voluntario {

    private String nome;
    private String programa;
    private String local;

    public Voluntario(String nome, String programa, String local){
        this.nome = nome;
        this.programa = programa;
        this.local = local;
    }

    public String getNome(){
        return this.nome;
    }

    public String getPrograma(){
        return this.programa;
    }

    public String getLocal(){
        return this.local;
    }
}

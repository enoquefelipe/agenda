package com.enoqueleal.agenda.model;

import java.io.Serializable;

/**
 * Created by enoque.santos on 27/10/2016.
 */

public class Aluno implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }
}

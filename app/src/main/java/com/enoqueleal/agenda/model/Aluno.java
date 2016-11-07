package com.enoqueleal.agenda.model;

import java.io.Serializable;

/**
 * Classe responsável por representar as informaçõs de passoas como Nome e Sobrenome.
 * Created by enoque.santos on 27/10/2016.
 */

public class Aluno implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private String site;
    private String caminhoFoto;

    /* Getters and Setters  */
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }
}

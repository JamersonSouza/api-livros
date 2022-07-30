package com.james.bookstore.DTO;

import java.io.Serializable;

import com.james.bookstore.Entidades.Livro;

public class LivroDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    public LivroDTO(){

    }

    
    public LivroDTO(Livro objeto) {
        this.id = objeto.getId();
        this.titulo = objeto.getTitulo();
        this.nomeAutor = objeto.getNomeAutor();
        this.texto = objeto.getTexto();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    


}

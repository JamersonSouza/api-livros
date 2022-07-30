package com.james.bookstore.DTO;

import java.io.Serializable;

import com.james.bookstore.Entidades.Categoria;

public class CategoriaDTO implements Serializable {

       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private Long id;
    private String nome;
    private String descricao;
 


    public CategoriaDTO(){

    }

    public CategoriaDTO(Categoria objeto) {
        this.id = objeto.getId();
        this.nome = objeto.getNome();
        this.descricao = objeto.getDescricao();
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}

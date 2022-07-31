package com.james.bookstore.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.james.bookstore.Entidades.Categoria;

public class CategoriaDTO implements Serializable {

       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private Long id;
    @NotEmpty(message = "Campo Nome não pode ser vazio")
    @Length(min = 3, max = 100, message = "Campo Nome deve conter entre 3 a 100 caracteres")
    private String nome;
    @NotEmpty(message = "Campo Descrição não pode ser vazio")
    @Length(min = 3, max = 200, message = "Campo Descrição deve conter entre 3 a 200 caracteres")
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

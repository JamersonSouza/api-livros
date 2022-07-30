package com.james.bookstore.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.bookstore.Entidades.Categoria;
import com.james.bookstore.Entidades.Livro;
import com.james.bookstore.repositories.CategoriaRepositorio;
import com.james.bookstore.repositories.LivroRepositorio;

@Service
public class DBService {

    @Autowired
	private CategoriaRepositorio catRep;

	@Autowired
	private LivroRepositorio livroRep;
    
    public void instanciaBaseDeDados(){


		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Finanças", "Livro Financeiro");
		Categoria cat3 = new Categoria(null, "Auto Ajuda", "Livro ajuda as pessoas");
		Categoria cat4 = new Categoria(null, "Designer", "Livros de Designer Gráfico");

		Livro l1 = new Livro(null, "clean code", "robert martin", "lorim ipsum", cat1);
		Livro l2 = new Livro(null, "Do Mil ao Milhão", "Thiago Nigro", "lorim ipsum", cat2);
		Livro l3 = new Livro(null, "A sutil arte de ligar o foda-se", "Mark Manson", "lorim ipsum", cat3);
		Livro l4 = new Livro(null, "Designer para não designer", "desconhecido", "lorim ipsum", cat4);
		Livro l5 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Livro l6 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l5, l6));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3));
		cat4.getLivros().addAll(Arrays.asList(l4));

		this.catRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		this.livroRep.saveAll(Arrays.asList(l1, l2, l3, l4));

    }

}

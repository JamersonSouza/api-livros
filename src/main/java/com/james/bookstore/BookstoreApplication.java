package com.james.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.james.bookstore.Entidades.Categoria;
import com.james.bookstore.Entidades.Livro;
import com.james.bookstore.repositories.CategoriaRepositorio;
import com.james.bookstore.repositories.LivroRepositorio;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepositorio catRep;

	@Autowired
	private LivroRepositorio livroRep;


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");

		Livro l1 = new Livro(null, "clean code", "robert martin", "lorim ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));

		this.catRep.saveAll(Arrays.asList(cat1));
		this.livroRep.saveAll(Arrays.asList(l1));
	}

}

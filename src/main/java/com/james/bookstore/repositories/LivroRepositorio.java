package com.james.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.james.bookstore.Entidades.Categoria;
import com.james.bookstore.Entidades.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

}

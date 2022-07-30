package com.james.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.james.bookstore.Entidades.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

    @Query("SELECT obj FROM Livro obj where obj.categoria.id = :categoria_id")
    List<Livro> findAllByCategoria(@Param(value = "categoria_id") Long categoria_id);


}

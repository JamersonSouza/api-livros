package com.james.bookstore.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.bookstore.Entidades.Categoria;
import com.james.bookstore.repositories.CategoriaRepositorio;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepositorio catrep;

    public Categoria findById(Long id){
        Optional<Categoria> obj = catrep.findById(id);
        return obj.orElse(null);
    }
    
}

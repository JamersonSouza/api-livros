package com.james.bookstore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.bookstore.Entidades.Categoria;
import com.james.bookstore.ServiceExceptions.ObjectNotFoundException;
import com.james.bookstore.repositories.CategoriaRepositorio;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepositorio catrep;

    public Categoria findById(Long id){
        Optional<Categoria> obj = catrep.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + 
            " Tipo: " + Categoria.class.getName()));
    
    } 

    public List<Categoria> findAll(){
        return catrep.findAll();
    }

}
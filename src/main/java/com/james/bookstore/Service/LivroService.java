package com.james.bookstore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.bookstore.Entidades.Livro;
import com.james.bookstore.ServiceExceptions.ObjectNotFoundException;
import com.james.bookstore.repositories.LivroRepositorio;

@Service
public class LivroService {

    @Autowired
    private LivroRepositorio livrorep;

    public Livro findById(Long id) {
        Optional<Livro> obj = livrorep.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto Não encontrado! Id: " + id + " Tipo: " + Livro.class.getName()) );
    }

    public List<Livro> findAll(){
        return livrorep.findAll();
    }

    
}

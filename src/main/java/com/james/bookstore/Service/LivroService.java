package com.james.bookstore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.bookstore.Entidades.Categoria;
import com.james.bookstore.Entidades.Livro;
import com.james.bookstore.ServiceExceptions.ObjectNotFoundException;
import com.james.bookstore.repositories.LivroRepositorio;

@Service
public class LivroService {

    @Autowired
    private LivroRepositorio livrorep;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Long id) {
        Optional<Livro> obj = livrorep.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto Não encontrado! Id: " + id + " Tipo: " + Livro.class.getName()) );
    }

    public List<Livro> findAll(Long categoria_id){
        return livrorep.findAllByCategoria(categoria_id);
    }

    public Livro savebook(Long categoria_id, Livro book) {
        book.setId(null);
        Categoria cat = categoriaService.findById(categoria_id);
        book.setCategoria(cat);
        return livrorep.save(book);
    }

    public List<Livro> listBooks() {
      return livrorep.findAll();
    }

    //atualizar livro
    public Livro update(Long id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return livrorep.save(newObj);

    }
    //método responsável por pegar as informações e inserir na atualização do livro
    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNomeAutor(obj.getNomeAutor());
        newObj.setTexto(obj.getTexto());
    }

    
}

package com.james.bookstore.Resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.james.bookstore.DTO.LivroDTO;
import com.james.bookstore.Entidades.Livro;
import com.james.bookstore.Service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
    

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //lista o livro com uma categoria como parametro
    @GetMapping()
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long categoria_id){
        //recebendo a lista de livros do service
        List<Livro> listBook = livroService.findAll(categoria_id);
        //convertendo a lista em um DTO
        List<LivroDTO> listDTObook = listBook.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTObook);
    }

    //lista todos os livros 
    @GetMapping("/all-books")
    public ResponseEntity<List<LivroDTO>> listAllBooks(){
         //recebendo a lista de livros do service
        List<Livro> listBooks = livroService.listBooks();
         //convertendo a lista em um DTO
         List<LivroDTO> listBooksDTO = listBooks.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
         return ResponseEntity.ok().body(listBooksDTO);


    }

    //método para salvar um livro
    @PostMapping()
    public ResponseEntity<Livro> saveBook(@RequestParam(value = "categoria", defaultValue = "0") Long categoria_id,
    @RequestBody Livro book){

        book = livroService.savebook(categoria_id, book);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/livros/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(book);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateBook(@PathVariable Long id, @RequestBody Livro obj){

        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);


    }

}

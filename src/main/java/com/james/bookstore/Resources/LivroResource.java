package com.james.bookstore.Resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping()
    public ResponseEntity<List<LivroDTO>> findAll(){
        //recebendo a lista de livros do service
        List<Livro> listBook = livroService.findAll();
        //convertendo a lista em um DTO
        List<LivroDTO> listDTObook = listBook.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTObook);
    }

}

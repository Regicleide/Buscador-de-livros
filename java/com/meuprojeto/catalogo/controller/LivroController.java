package com.meuprojeto.catalogo.controller;
import com.meuprojeto.catalogo.model.Livro;
import com.meuprojeto.catalogo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/livros")
    public class LivroController {

        @Autowired
        private LivroService livroService;

        @GetMapping
        public List<Livro> getAllLivros() {
            return livroService.getAllLivros();
        }

        @GetMapping("/{id}")
        public Livro getLivroById(@PathVariable Long id) {
            return livroService.getLivroById(id);
        }

        @PostMapping
        public Livro addLivro(@RequestBody Livro livro) {
            return livroService.addLivro(livro);
        }

        @PutMapping("/{id}")
        public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livroDetails) {
            return livroService.updateLivro(id, livroDetails);
        }

        @DeleteMapping("/{id}")
        public void deleteLivro(@PathVariable Long id) {
            livroService.deleteLivro(id);
        }
    }



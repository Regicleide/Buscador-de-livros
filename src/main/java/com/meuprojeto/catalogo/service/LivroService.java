package com.meuprojeto.catalogo.service;

import com.meuprojeto.catalogo.model.Livro;
import com.meuprojeto.catalogo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public Livro getLivroById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Livro addLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, Livro livroDetails) {
        Livro livro = livroRepository.findById(id).orElse(null);

        if (livro != null) {
            livro.setTitulo(livroDetails.getTitulo());
            livro.setAutor(livroDetails.getAutor());
            return livroRepository.save(livro);
        }

        return null;
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}

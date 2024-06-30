package com.meuprojeto.catalogo.repository;

import com.meuprojeto.catalogo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface LivroRepository extends JpaRepository<Livro, Long> {
    }



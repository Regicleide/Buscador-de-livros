
package com.meuprojeto.catalogo;

import com.meuprojeto.catalogo.model.Livro;
import com.meuprojeto.catalogo.repository.LivroRepository;
import com.meuprojeto.catalogo.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private GutendexService gutendexService;

    public static void main(String[] args) {
        SpringApplication.run(CatalogoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar livros");
            System.out.println("2. Buscar livros na API Gutendex");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarLivros();
                    break;
                case 2:
                    buscarLivrosNaAPI();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void listarLivros() {
        System.out.println("Listando todos os livros no banco de dados:");
        Iterable<Livro> livros = livroRepository.findAll();
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    private void buscarLivrosNaAPI() {
        System.out.println("Buscando livros na API Gutendex...");
        Livro[] livros = gutendexService.buscarLivros();
        for (Livro livro : livros) {
            livroRepository.save(livro);
        }
        System.out.println("Livros salvos no banco de dados.");
    }
}


package br.com.mesttra.filmesmesttra.controllers;

import br.com.mesttra.filmesmesttra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
public class FilmesControllerIntegrationTest {

    @Autowired
    private FilmesController filmesController;

    @Autowired
    private FilmeRepository filmeRepository;

    @Test
    @Sql("classpath:add2MoviesWithPalavraChave100.sql")
    //@Transactional
    public void test(){
        filmesController.findAll(null, null).forEach(filme -> {
            System.out.println(filme.getPalavrasChaves());
        });
    }

}

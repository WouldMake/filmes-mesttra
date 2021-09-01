package br.com.mesttra.filmesmesttra.repositories;

import br.com.mesttra.filmesmesttra.FilmeEntityFactory;
import br.com.mesttra.filmesmesttra.model.FilmeEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FilmeRepositoryIntegrationTest {

    @Autowired
    private FilmeRepository filmeRepository;

    @AfterEach
    @Sql("classpath:cleanDatabase.sql")
    public void clean(){}

    @Test
    //@Sql("classpath:addSenhorDosAneis.sql")
    public void shouldFindFilmeByTitulo(){
        FilmeEntity filmeEntity = FilmeEntityFactory.getInstance()
                .titulo("O Titulo Que Importa")
                .build();

        assertThat(filmeRepository.findByTitulo("Senhor dos Aneis").isPresent())
                .isTrue();
    }

    @Test
    public void shouldReturnEmptyWhenFilmeWasNotFound(){
        assertThat(filmeRepository.findByTitulo("Senhor dos Aneis").isPresent())
                .isFalse();
    }

    @Test
    @Sql("classpath:add2MoviesWithCategoria100.sql")
    public void shouldReturnFilmesByCategoria(){
        List<FilmeEntity> filmes = filmeRepository.findByCategoria_Id(100L);
        assertThat(filmes).hasSize(2);
    }

    @Test
    @Sql("classpath:add2MoviesWithPalavraChave100.sql")
    public void shouldReturnFilmesByPalavraChave(){
        List<FilmeEntity> filmes = filmeRepository.findByPalavrasChave("TESTE");
        assertThat(filmes).hasSize(2);
    }

}
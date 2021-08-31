package br.com.mesttra.filmesmesttra;

import br.com.mesttra.filmesmesttra.model.FilmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmeRepository extends JpaRepository<FilmeEntity, Long> {

    List<FilmeEntity> findByTitulo(String titulo);

    List<FilmeEntity> findByCategoria_Id(Long idCategoria);

    @Query(value = "SELECT f FROM FilmeEntity f JOIN f.palavrasChaves pc WHERE pc.palavraChave = :palavraChave")
    /*@Query(value = "select f.* from filmes f\n" +
            "inner join filmes_palavras_chaves fpc ON\n" +
            "fpc.id_filme = f.id\n" +
            "inner join palavras_chaves pc \n" +
            "on fpc.id_palavra_chave = pc.id\n" +
            "WHERE \n" +
            "pc.palavra_chave = ?1", nativeQuery = true)*/
    List<FilmeEntity> findByPalavrasChave(@Param("palavraChave") String palavraChave);

}

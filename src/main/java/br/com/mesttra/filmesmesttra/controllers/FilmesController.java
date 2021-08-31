package br.com.mesttra.filmesmesttra.controllers;

import br.com.mesttra.filmesmesttra.CategoriaRepository;
import br.com.mesttra.filmesmesttra.FilmeRepository;
import br.com.mesttra.filmesmesttra.model.FilmeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmesController {

    private final FilmeRepository filmeRepository;
    private final CategoriaRepository categoriaRepository;

    @GetMapping
    public List<FilmeEntity> findAll(){
        return filmeRepository.findAll();
    }

    @GetMapping("/byCategoria")
    public List<FilmeEntity> findByIdCategoria(@RequestParam("idCategoria") Long idCategoria){
        return filmeRepository.findByCategoria_Id(idCategoria);
    }

    @GetMapping("/byPalavraChave")
    public List<FilmeEntity> findByPalavraChave(@RequestParam("palavraChave") String palavraChave){
        return filmeRepository.findByPalavrasChave(palavraChave);
    }

    @PostMapping
    public FilmeEntity save(@RequestBody FilmeEntity filmeEntity){
        return filmeRepository.save(filmeEntity);
    }





}

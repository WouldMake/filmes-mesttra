package br.com.mesttra.filmesmesttra.controllers;

import br.com.mesttra.filmesmesttra.model.FilmeEntity;
import br.com.mesttra.filmesmesttra.repositories.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmesController {

    private final FilmeRepository filmeRepository;

    @GetMapping
    public List<FilmeEntity> findAll(@RequestParam(value = "pageSize", required = false) Integer pageSize,
                                     @RequestParam(value = "pageIndex", required = false) Integer pageIndex){
        if(pageSize != null && pageIndex != null){
            return filmeRepository.findAll(
                    PageRequest.of(pageIndex, pageSize, Sort.by("titulo"))).getContent();
        }
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

    @DeleteMapping
    public void delete(Long filmeId){
        filmeRepository.deleteById(filmeId);
    }








}

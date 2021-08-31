package br.com.mesttra.filmesmesttra.controllers;

import br.com.mesttra.filmesmesttra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.mockito.Mockito.*;

class FilmesControllerTest {


    private final FilmeRepository mockedFilmeRepository = mock(FilmeRepository.class);
    private FilmesController filmesController = new FilmesController(mockedFilmeRepository);

    @Test
    public void whenPageSizeAndPageIndexWasNullShouldCallFindAllWithoutParameters(){
        filmesController.findAll(null, null);
        verify(mockedFilmeRepository).findAll();
    }

    @Test
    public void whenHasPageSizeAndIndexShouldCallFindAllWithPagination(){
        final PageRequest pagination = PageRequest.of(0, 1, Sort.by("titulo"));
        when(mockedFilmeRepository.findAll(pagination)).thenReturn(Page.empty());
        filmesController.findAll(1, 0);
        verify(mockedFilmeRepository).findAll(pagination);
    }

}
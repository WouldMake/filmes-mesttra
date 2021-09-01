package br.com.mesttra.filmesmesttra;

import br.com.mesttra.filmesmesttra.model.FilmeEntity;

public class FilmeEntityFactory {

    public static FilmeEntity.FilmeEntityBuilder getInstance(){
        return FilmeEntity.builder()
                .id(1L)
                .titulo("Sei lá")
                .descricao("Alguma Descrição");
    }
}

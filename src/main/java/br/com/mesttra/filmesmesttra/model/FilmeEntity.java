package br.com.mesttra.filmesmesttra.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filmes")
@Data
public class FilmeEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;
    @ManyToMany
    @JoinTable(
            name = "filmes_palavras_chaves",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_palavra_chave")
    )
    private List<PalavraChave> palavrasChaves;

}

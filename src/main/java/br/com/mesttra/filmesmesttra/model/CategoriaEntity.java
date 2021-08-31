package br.com.mesttra.filmesmesttra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
public class CategoriaEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<FilmeEntity> filmes;

}

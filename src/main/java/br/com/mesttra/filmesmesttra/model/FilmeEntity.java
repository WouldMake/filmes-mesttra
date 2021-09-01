package br.com.mesttra.filmesmesttra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "filmes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmeEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;

    @ManyToMany
    @JoinTable(
            name = "filmes_palavras_chaves",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_palavra_chave")
    )
    private List<PalavraChave> palavrasChaves;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime ultimaAlteracao;

}

package br.com.mesttra.filmesmesttra.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "palavras_chaves")
@Data
public class PalavraChave {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "palavra_chave", nullable = false, unique = true)
    private String palavraChave;

}

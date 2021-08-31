package br.com.mesttra.filmesmesttra;

import br.com.mesttra.filmesmesttra.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}

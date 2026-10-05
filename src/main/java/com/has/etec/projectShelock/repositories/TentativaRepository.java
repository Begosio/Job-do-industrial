package com.has.etec.projectShelock.repositories;

import com.has.etec.projectShelock.entities.Tentativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TentativaRepository extends JpaRepository<Tentativa, Long> {
    boolean existsByUsuarioIdAndCasoId(
            Long usuarioId,
            Long casoId);
    List<Tentativa> findAllByOrderByTempoAsc();
}

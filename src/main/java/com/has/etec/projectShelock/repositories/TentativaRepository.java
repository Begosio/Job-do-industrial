package com.has.etec.projectShelock.repositories;

import com.has.etec.projectShelock.entities.Tentativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TentativaRepository extends JpaRepository<Tentativa, Long> {
    List<Tentativa> findByUsuarioId(Long usuarioId);
    List<Tentativa> findAllByOrderByTempoAsc();
    Optional<Tentativa> findByUsuarioIdAndCasoId(Long usuarioId, Long casoId);
}
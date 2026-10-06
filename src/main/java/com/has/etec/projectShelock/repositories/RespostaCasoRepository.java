package com.has.etec.projectShelock.repositories;

import com.has.etec.projectShelock.entities.RespostaCaso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RespostaCasoRepository extends JpaRepository<RespostaCaso, Long> {
    Optional<RespostaCaso> findByCasoIdAndCorretaTrue(Long casoId);
}
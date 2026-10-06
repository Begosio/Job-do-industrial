package com.has.etec.projectShelock.repositories;

import com.has.etec.projectShelock.entities.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoRepository extends JpaRepository<Caso, Long> {
}
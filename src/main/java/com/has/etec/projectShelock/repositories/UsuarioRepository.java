package com.has.etec.projectShelock.repositories;

import com.has.etec.projectShelock.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNome(String nome);
}

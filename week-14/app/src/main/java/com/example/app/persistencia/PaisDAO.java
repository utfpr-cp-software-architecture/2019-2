package com.example.app.persistencia;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisDAO extends JpaRepository<Pais, Long> {
    Optional<Pais> findByNome(String nome);
}

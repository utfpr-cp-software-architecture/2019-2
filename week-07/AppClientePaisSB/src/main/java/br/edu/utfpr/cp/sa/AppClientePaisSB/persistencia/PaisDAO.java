package br.edu.utfpr.cp.sa.AppClientePaisSB.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisDAO extends JpaRepository<Pais, Long> {
    Pais findByNome(String nome);
}

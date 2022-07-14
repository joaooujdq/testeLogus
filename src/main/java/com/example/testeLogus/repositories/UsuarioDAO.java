package com.example.testeLogus.repositories;

import com.example.testeLogus.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String login);
}

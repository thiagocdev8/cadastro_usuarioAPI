package com.solarx.cadastro_usuarioAPI.Infraestructure.repository;

import com.solarx.cadastro_usuarioAPI.Infraestructure.Entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}

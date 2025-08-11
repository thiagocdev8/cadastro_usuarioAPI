package com.solarx.cadastro_usuarioAPI.Infraestructure.repository;

import com.solarx.cadastro_usuarioAPI.Infraestructure.Entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//have to extend JpaRespository so we get the JPA methods
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Transactional //using transactional incase the email isnt found and the user doesnt exist
    void deleteByEmail(String email);
}

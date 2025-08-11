package com.solarx.cadastro_usuarioAPI.business;

import com.solarx.cadastro_usuarioAPI.Infraestructure.Entities.Usuario;
import com.solarx.cadastro_usuarioAPI.Infraestructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario){
        usuarioRepository.saveAndFlush(usuario);
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    }

    public Usuario buscarUsuarioByEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado"));
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    public void deleteByEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }

    public void atualizarUsuarioById(Long id, Usuario usuario){
        Usuario usuarioEntity = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .name(usuario.getName() != null ? usuario.getName() : usuarioEntity.getName())
                .age(usuario.getAge() != 0 ? usuario.getAge() : usuarioEntity.getAge())
                .id(usuarioEntity.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }

    public void atualizarUsuarioByEmail(String email, Usuario usuario){
        Usuario usuarioEntity = buscarUsuarioByEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail())
                .name(usuario.getName() != null ? usuario.getName() : usuarioEntity.getName())
                .age(usuario.getAge() != 0 ? usuario.getAge() : usuarioEntity.getAge())
                .id(usuarioEntity.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }




}

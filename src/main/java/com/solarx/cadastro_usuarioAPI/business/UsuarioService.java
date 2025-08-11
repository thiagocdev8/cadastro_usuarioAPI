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

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado"));
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    public void deleteByEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }






}

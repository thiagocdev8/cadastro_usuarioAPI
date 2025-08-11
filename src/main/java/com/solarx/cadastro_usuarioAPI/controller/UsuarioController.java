package com.solarx.cadastro_usuarioAPI.controller;

import com.solarx.cadastro_usuarioAPI.Infraestructure.Entities.Usuario;
import com.solarx.cadastro_usuarioAPI.business.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    //create user
    @PostMapping("/create")
    public ResponseEntity<String> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso");
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioByEmail(@RequestParam String email){
        Usuario usuario = usuarioService.buscarUsuarioByEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioPorId(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUsuarioByEmail(@RequestParam String email){
        usuarioService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioByEmail(@RequestParam String email, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioByEmail(email, usuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUsuarioByEmail(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioById(id, usuario);
        return ResponseEntity.ok().build();
    }




}

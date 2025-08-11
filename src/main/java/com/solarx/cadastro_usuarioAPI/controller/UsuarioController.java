package com.solarx.cadastro_usuarioAPI.controller;

import com.solarx.cadastro_usuarioAPI.Infraestructure.Entities.Usuario;
import com.solarx.cadastro_usuarioAPI.business.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//have to use these annotations so spring will know this is my controller
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //dependecy injection the services (the logic)
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    //create user
    @PostMapping
    public ResponseEntity<String> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso");
    }

    //list users
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    //find by email (ex: /usuario/email?email=thiago@gmail.com)
    @GetMapping("/email")
    public ResponseEntity<Usuario> buscarUsuarioByEmail(@RequestParam String email){
        Usuario usuario = usuarioService.buscarUsuarioByEmail(email);
        return ResponseEntity.ok(usuario);
    }

    //find by id (ex: /usuario/1)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioPorId(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    //delete user by id (ex: /usuario/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // delete user by ID (ex: /usuario/email?email=thiago@gmail.com)
    @DeleteMapping("/email")
    public ResponseEntity<Void> deleteUsuarioByEmail(@RequestParam String email){
        usuarioService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    // update user by email (ex: /usuario/email?email=thiago@gmail.com)
    @PutMapping("/email")
    public ResponseEntity<Void> atualizarUsuarioByEmail(@RequestParam String email, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioByEmail(email, usuario);
        return ResponseEntity.ok().build();
    }

    //update user by id (ex: /usuario/1)
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUsuarioByEmail(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioById(id, usuario);
        return ResponseEntity.ok().build();
    }




}

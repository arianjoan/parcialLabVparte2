package com.example.SimulacroParcial.controller;


import com.example.SimulacroParcial.entity.Publicacion;
import com.example.SimulacroParcial.entity.Punto2;
import com.example.SimulacroParcial.entity.Usuario;
//import com.example.SimulacroParcial.entity.UsuarioxPublicacion;
//import com.example.SimulacroParcial.repository.UsuarioProyeccion;
//import com.example.SimulacroParcial.repository.UsuarioPublicacionProyeccion;
import com.example.SimulacroParcial.repository.ProjectionPunto1;
import com.example.SimulacroParcial.repository.PublicacionRepository;
import com.example.SimulacroParcial.repository.Punto2Repository;
import com.example.SimulacroParcial.repository.UsuarioRepository;
//import com.example.SimulacroParcial.repository.UsuarioxPublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PublicacionRepository publicacionRepository;
    @Autowired
    Punto2Repository punto2Repository;

    @GetMapping("")
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    @PostMapping("")
    public void addUsuario(@RequestBody Usuario usuario,@RequestHeader("User-Agent") String agente){
        usuario.setBrowser(agente);
        usuarioRepository.save(usuario);
    }

    @PostMapping("/{id}")
    public void addPublicacion(@PathVariable Integer id, @RequestBody Publicacion publicacion){
        Usuario u = usuarioRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        publicacion.setFechaPublicacion(LocalDateTime.now());
        u.getPublicaciones().add(publicacion);
        publicacion.setUsuario(u);
        usuarioRepository.save(u);
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        Usuario u = usuarioRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return u;
    }

    @GetMapping("/punto1")
    public List<ProjectionPunto1> getPunto1(){
        return publicacionRepository.getProjectionPunto1();
    }

   @GetMapping("/punto2")
   public List<Punto2> getPunto2(){
        return punto2Repository.getPunto2();
   }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        Usuario u = usuarioRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        usuarioRepository.delete(u);
        return new ResponseEntity<String>("El usuario ha sido borrado exitosamente",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario, @RequestHeader("User-Agent") String browser){
        Usuario u = usuarioRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        u.setNombre(usuario.getNombre());
        u.setApellido(usuario.getApellido());
        u.setBrowser(browser);
        usuarioRepository.save(u);
    }
}

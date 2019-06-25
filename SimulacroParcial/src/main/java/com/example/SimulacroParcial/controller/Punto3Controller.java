package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.entity.Comentario;
import com.example.SimulacroParcial.entity.Publicacion;
import com.example.SimulacroParcial.entity.Punto3;
import com.example.SimulacroParcial.entity.Usuario;
import com.example.SimulacroParcial.service.Punto3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/allContent")
public class Punto3Controller {

    @Autowired
    Punto3Service punto3Service;

    @GetMapping("")
    ResponseEntity<?> getAllContent() {
        try {
            Punto3 punto3 = new Punto3();
            CompletableFuture usuarioContent = punto3Service.getUsuarioContent();
            CompletableFuture publicacionContent = punto3Service.getPublicacionContent();
            CompletableFuture comentarioContent = punto3Service.getComentarioContent();

            punto3.setUsuarios((List<Usuario>) usuarioContent.join());
            punto3.setComentarios((List<Comentario>) comentarioContent.join());
            punto3.setPublicaciones((List<Publicacion>) publicacionContent.join());

            return ResponseEntity.status(200).body(punto3);
        } catch (InterruptedException e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }

    }

}

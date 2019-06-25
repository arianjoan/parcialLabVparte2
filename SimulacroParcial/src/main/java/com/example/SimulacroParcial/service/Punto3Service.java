package com.example.SimulacroParcial.service;

import com.example.SimulacroParcial.entity.Comentario;
import com.example.SimulacroParcial.entity.Publicacion;
import com.example.SimulacroParcial.entity.Punto3;
import com.example.SimulacroParcial.entity.Usuario;
import com.example.SimulacroParcial.repository.ComentarioRepository;
import com.example.SimulacroParcial.repository.PublicacionRepository;
import com.example.SimulacroParcial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class Punto3Service {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PublicacionRepository publicacionRepository;
    @Autowired
    ComentarioRepository comentarioRepository;

    @Async("ThreadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> getUsuarioContent() throws InterruptedException {
        Thread.sleep(2000);
        return CompletableFuture.completedFuture(usuarioRepository.findAll());

    }

    @Async("ThreadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> getPublicacionContent() throws InterruptedException {
        Thread.sleep(2000);
        return CompletableFuture.completedFuture(publicacionRepository.findAll());
    }

    @Async("ThreadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> getComentarioContent() throws InterruptedException {
        Thread.sleep(2000);
        return CompletableFuture.completedFuture(comentarioRepository.findAll());

    }

}

package com.example.SimulacroParcial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Punto3 {
    private List<Usuario> usuarios;
    private List<Publicacion> publicaciones;
    private List<Comentario> comentarios;
}

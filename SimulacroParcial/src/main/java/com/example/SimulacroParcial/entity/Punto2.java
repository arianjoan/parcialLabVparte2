package com.example.SimulacroParcial.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Punto2 {
    @Id
    private String publicacion;
    private String nombreduenio;
    private String cantidadcomentarios;
}

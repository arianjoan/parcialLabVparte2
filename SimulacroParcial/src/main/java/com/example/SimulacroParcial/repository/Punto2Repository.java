package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.entity.Punto2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Punto2Repository extends JpaRepository<Punto2,String> {
    @Query(value = "select publicaciones.descripcion as publicacion," +
            "usuarios.nombre as nombreduenio," +
            "count(comentarios.id) as cantidadcomentarios " +
            "from publicaciones inner join usuarios on " +
            "usuarios.id = publicaciones.usuario_id " +
            "inner join comentarios on " +
            "publicaciones.id = comentarios.publicacion_id " +
            "group by (publicaciones.id)",nativeQuery = true)
    List<Punto2> getPunto2();
}

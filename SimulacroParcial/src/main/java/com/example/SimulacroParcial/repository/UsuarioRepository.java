package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    /*@Query(value = "Select nombre,apellido from usuarios where nombre = ?1",nativeQuery = true)
    List<UsuarioProyeccion> getUsersJuan(String name);

    @Query(value = "Select usuarios.nombre as nombre, " +
            "usuarios.apellido as apellido, " +
            "publicaciones.descripcion as descripcion " +
            "from usuarios " +
            "inner join publicaciones " +
            "on usuarios.id = publicaciones.usuario_id",nativeQuery = true)
    List<UsuarioPublicacionProyeccion> getUsersPublications();*/

}

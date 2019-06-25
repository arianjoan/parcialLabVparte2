package com.example.SimulacroParcial.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publicaciones")
public class Publicacion {

    @GeneratedValue
    @Id
    private Integer id;
    private String descripcion;
    private String foto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime FechaPublicacion;
    private boolean liked;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "publicacion")
    private List<Comentario> comentarios;

    public List<Comentario> getComentarios(){
        return comentarios;
    }
}

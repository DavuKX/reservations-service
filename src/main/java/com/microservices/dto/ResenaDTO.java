package com.microservices.dto;

import org.bson.types.ObjectId;

import java.util.Date;

public class ResenaDTO {
    private String id;
    private int habitacionId;
    private int usuarioId;
    private Date fecha;
    private int calificacion;
    private String comentario;

    public ResenaDTO() {}

    public ResenaDTO(String id, int habitacionId, int usuarioId,
                      Date fecha, int calificacion, String comentario){
        this.id = id;
        this.habitacionId = habitacionId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

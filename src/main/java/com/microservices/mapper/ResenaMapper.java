package com.microservices.mapper;

import com.microservices.dto.ResenaDTO;
import com.microservices.models.Resena;
import org.bson.types.ObjectId;

public class ResenaMapper {
    public static ResenaDTO toDto(Resena resena) {
        if (resena == null) {
            return null;
        }

        ResenaDTO dto = new ResenaDTO();
        dto.setId(resena.getId() != null ? resena.getId().toString() : null);
        dto.setHabitacionId(resena.getHabitacionId());
        dto.setUsuarioId(resena.getUsuarioId());
        dto.setCalificacion(resena.getCalificacion());
        dto.setComentario(resena.getComentario());

        return dto;
    }

    public static Resena toEntity(ResenaDTO dto) {
        if (dto == null) {
            return null;
        }

        Resena resena = new Resena();
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            resena.setId(new ObjectId(dto.getId()));
        }
        resena.setHabitacionId(dto.getHabitacionId());
        resena.setUsuarioId(dto.getUsuarioId());
        resena.setFecha(dto.getFecha());
        resena.setCalificacion(dto.getCalificacion());
        resena.setComentario(dto.getComentario());

        return resena;
    }
}

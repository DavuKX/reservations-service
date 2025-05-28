package com.microservices.service;

import com.microservices.dto.ResenaDTO;
import com.microservices.dto.ReservaDTO;
import com.microservices.mapper.ResenaMapper;
import com.microservices.models.Resena;
import com.microservices.models.Reserva;
import com.microservices.repository.ResenaRepository;
import com.microservices.repository.ReservaRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ResenaService {
    private final ResenaRepository repository;

    public ResenaService(ResenaRepository repository) {
        this.repository = repository;
    }

    public ResenaDTO save(Resena resena) throws Exception {
        if (resena.getHabitacionId() <= 0) {
            throw new IllegalArgumentException("ID de habitación inválido");
        }

        if (resena.getUsuarioId() <= 0) {
            throw new IllegalArgumentException("ID de usuario inválido");
        }

        if (resena.getFecha() == null) {
            resena.setFecha(new Date());
        }

        Resena saved = repository.save(resena);
        return ResenaMapper.toDto(saved);
    }

    public List<ResenaDTO> findAll() {
        return repository.findAll().stream()
                .map(ResenaMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ResenaDTO> findByHabitacionId(int habitacionId) {
        if (habitacionId <= 0) {
            throw new IllegalArgumentException("ID de habitación inválido");
        }

        return repository.findByHabitacionId(habitacionId).stream()
                .map(ResenaMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean delete(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID de resena inválido");
        }

        return repository.delete(id);
    }
}

package com.microservices.repository;

import com.microservices.models.Resena;

import java.util.List;

public interface IResenaRepository {
    Resena save(Resena reserva);
    List<Resena> findByHabitacionId(int habitacionId);
    List<Resena> findAll();
    boolean delete(String id);
}

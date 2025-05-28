package com.microservices.repository;

import com.microservices.dao.ResenaDAO;
import com.microservices.models.Resena;

import java.util.List;

public class ResenaRepository implements  IResenaRepository{
    private final ResenaDAO resenaDAO = new ResenaDAO();

    @Override
    public Resena save(Resena reserva) {
        return resenaDAO.save(reserva);
    }

    @Override
    public List<Resena> findByHabitacionId(int habitacionId) {
        return resenaDAO.findByHabitacionId(habitacionId);
    }

    @Override
    public List<Resena> findAll() {
        return resenaDAO.findAll();
    }

    @Override
    public boolean delete(String id) {
        return resenaDAO.delete(id);
    }
}

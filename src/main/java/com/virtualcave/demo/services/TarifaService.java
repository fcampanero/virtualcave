package com.virtualcave.demo.services;

import com.virtualcave.demo.entities.Tarifa;
import com.virtualcave.demo.model.TarifaRequest;

import java.util.List;
import java.util.Optional;

public interface TarifaService {

    List<Tarifa> findAll();

    Optional<Tarifa> findById(Long id);

    Long create(TarifaRequest newTarifa);

    boolean update(Long id, TarifaRequest tarifaRequest);

    void delete(Long id);
}

package com.virtualcave.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcave.demo.entities.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {

}

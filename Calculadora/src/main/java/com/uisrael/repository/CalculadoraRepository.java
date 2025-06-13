package com.uisrael.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uisrael.entity.Calculadora;

@Repository
public interface CalculadoraRepository extends JpaRepository<Calculadora, Integer>{

}

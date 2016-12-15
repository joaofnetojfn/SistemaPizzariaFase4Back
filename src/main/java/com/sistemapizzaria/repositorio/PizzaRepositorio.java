package com.sistemapizzaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemapizzaria.dominio.Pizza;

public interface PizzaRepositorio extends JpaRepository<Pizza, Integer>{

}

package com.sistemapizzaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemapizzaria.dominio.ItemPizza;

public interface ItemPizzaRepositorio extends JpaRepository<ItemPizza, Integer>{

}

package com.sistemapizzaria.repositorio;

import java.util.List;
import com.sistemapizzaria.dominio.Ingrediente;


public interface IngredienteRepositorioCustom {
	public Ingrediente buscarNomeExato(String nome);
	public List<Ingrediente> buscarTodosOrdenadosPorNome();
	public List<Ingrediente> buscarPorNome(String trecho);
}

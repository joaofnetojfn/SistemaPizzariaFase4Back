package com.sistemapizzaria.repositorio.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Component;


import com.sistemapizzaria.dominio.Ingrediente;
import com.sistemapizzaria.repositorio.IngredienteRepositorioCustom;

@Component
public class IngredienteRepositorioCustomImpl implements IngredienteRepositorioCustom {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public Ingrediente buscarNomeExato(String nome) {
		String jpql = "SELECT x FROM Ingrediente x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Ingrediente> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Ingrediente x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> buscarPorNome(String trecho) {
		String jpql = "SELECT x FROM Ingrediente x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}



}

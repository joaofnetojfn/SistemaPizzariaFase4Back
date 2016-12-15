package com.sistemapizzaria.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemapizzaria.dominio.Ingrediente;
import com.sistemapizzaria.servico.IngredienteServico;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteRecurso {
	
		@Autowired
		private IngredienteServico ing;


		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<Ingrediente>> todos(){
			List<Ingrediente> lista = ing.buscarTodosOrdenadosPorNome();
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
			Ingrediente ingre = ing.buscar(id);
			return ResponseEntity.status(HttpStatus.OK).body(ingre);
		}
		
		
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> criar(@RequestBody Ingrediente ingrediente) {
			ingrediente = ing.inserir(ingrediente);
			URI uri = getUri("/{id}", ingrediente.getCodIngrediente());
			return ResponseEntity.created(uri).build();
		}


		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
			ing.excluir(id);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> atualizar(@RequestBody Ingrediente ingrediente, @PathVariable("id") Integer id) {
			ingrediente.setCodIngrediente(id);
			ingrediente = ing.atualizar(ingrediente);
			return ResponseEntity.noContent().build();
		}
		
		private URI getUri(String nome, Integer valor) {
			return ServletUriComponentsBuilder.fromCurrentRequest().path(nome).buildAndExpand(valor).toUri();
		}



}

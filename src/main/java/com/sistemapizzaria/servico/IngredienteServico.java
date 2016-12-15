package com.sistemapizzaria.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.sistemapizzaria.dominio.Ingrediente;
import com.sistemapizzaria.repositorio.IngredienteRepositorio;
import com.sistemapizzaria.repositorio.IngredienteRepositorioCustom;
import com.sistemapizzaria.servico.excecao.NaoEncontradoException;
import com.sistemapizzaria.servico.excecao.ServicoException;
import com.sistemapizzaria.servico.excecao.ValidacaoException;

@Service
public class IngredienteServico {


	@Autowired
	private IngredienteRepositorio repo;


	@Autowired
	private IngredienteRepositorioCustom repoCustom;


	public void validar(Ingrediente x) throws ValidacaoException {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getPreco()==null) {
			erros.add("Favor preencher o campo Preço");
		}
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	public Ingrediente inserir(Ingrediente x) throws ServicoException {
		Ingrediente aux = repoCustom.buscarNomeExato(x.getNome());
		if (aux != null) {
			throw new ServicoException(1, "Já existe um Ingrediente com esse nome!");
		}
		validar(x);
		return repo.save(x);
	}


	public Ingrediente atualizar(Ingrediente x) throws ServicoException {
		Ingrediente aux = repo.findOne(x.getCodIngrediente());
		if (aux == null) {
			throw new NaoEncontradoException("Ingrediente não encontrado!", 1);
		}
		aux = repoCustom.buscarNomeExato(x.getNome());
		if (aux != null && aux.getCodIngrediente()!=x.getCodIngrediente()) {
			throw new ServicoException(1, "Já existe um outro Ingrediente com esse nome!");
		}
		validar(x);
		return repo.save(x);
	}


	public void excluir(int cod) throws ServicoException {
		Ingrediente ingre = repo.findOne(cod);
		if (ingre == null) {
			throw new NaoEncontradoException("Ingrediente não encontrado!", 1);
		}
		if (!ingre.getItens().isEmpty()) {
			throw new ServicoException(2, "Exclusão não permitida: este Ingrediente possui em uma pizza!");
		}
		repo.delete(ingre);
	}
	
	public Ingrediente buscar(int cod) {
		Ingrediente ingre = repo.findOne(cod);
		if (ingre == null) {
			throw new NaoEncontradoException("Ingrediente não encontrado!", 1);
		}
		return ingre;
	}
	
	public List<Ingrediente> buscarTodosOrdenadosPorNome() {
		return repoCustom.buscarTodosOrdenadosPorNome();
	}
	
	public List<Ingrediente> buscarPorNome(String trecho) {
		return repoCustom.buscarPorNome(trecho);
	}
}


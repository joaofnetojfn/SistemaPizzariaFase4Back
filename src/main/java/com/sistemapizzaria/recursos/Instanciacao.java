package com.sistemapizzaria.recursos;

import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sistemapizzaria.dominio.Ingrediente;
import com.sistemapizzaria.repositorio.IngredienteRepositorio;


//	import servico.ClienteServico;
//	import servico.IngredienteServico;
//	import servico.ItemPedidoServico;
//	import servico.ItemPizzaServico;
//	import servico.PedidoServico;
//	import servico.PizzaServico;
//	import servico.ServicoException;

@RestController
@WebServlet("/instanciacao")
public class Instanciacao{
	@Autowired
	private IngredienteRepositorio ingreRepo;
	


	@RequestMapping(method=RequestMethod.GET)
	public String todos() {
		

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Ingrediente i1 = new Ingrediente(null, "Tomate", new BigDecimal("2.50"));
		Ingrediente i2 = new Ingrediente(null, "Ovo", new BigDecimal("1.75"));
		Ingrediente i3 = new Ingrediente(null, "Queijo", new BigDecimal("3.00"));
		Ingrediente i4 = new Ingrediente(null, "Calabresa", new BigDecimal("5.50"));
		Ingrediente i5 = new Ingrediente(null, "Provolone", new BigDecimal("3.75"));



		ingreRepo.save(i1);
		ingreRepo.save(i2);
		ingreRepo.save(i3);
		ingreRepo.save(i4);
		ingreRepo.save(i5); 
		return "Pronto!";
	}
}

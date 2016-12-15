package com.sistemapizzaria.dominio;
import java.math.BigDecimal;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_itemPedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codItemPedido;
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name="pizza")
	@JsonIgnore
	private Pizza pizza;
	
	@ManyToOne
	@JoinColumn(name="pedido")
	@JsonIgnore
	private Pedido pedido;

	public ItemPedido() {		
	}
		
	public ItemPedido(Integer codItemPedido, Integer quantidade, Pizza pizza, Pedido pedido) {
		super();
		this.codItemPedido = codItemPedido;
		this.quantidade = quantidade;
		this.pizza = pizza;
		//pizza.addItemPedido(this);
		this.pedido = pedido;
		//pedido.addItem(this);
	}


	public BigDecimal subTotal() {
		BigDecimal subTotal;
		subTotal = this.pizza.valorTotal().multiply(new BigDecimal(this.quantidade));
		return subTotal;
	}

	public Integer getCodItemPedido() {
		return codItemPedido;
	}
	
	public void setCodItemPedido(Integer codItemPedido) {
		this.codItemPedido = codItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemPedido == null) ? 0 : codItemPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (codItemPedido == null) {
			if (other.codItemPedido != null)
				return false;
		} else if (!codItemPedido.equals(other.codItemPedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [codItemPedido=" + codItemPedido + ", quantidade=" + quantidade + "]";
	}

	
	
	
	

}

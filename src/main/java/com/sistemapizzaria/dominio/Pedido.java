package com.sistemapizzaria.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPedido;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;

	@OneToMany(mappedBy="pedido")
	@JsonIgnore
	private List<ItemPedido> itens;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	@JsonIgnore
	private Cliente cliente;

	public Pedido() {
		super();
		itens = new ArrayList<>();
	}

	public Pedido(Integer codPedido, Date data, Cliente cliente) {
		super();
		this.codPedido = codPedido;
		this.data = data;
		this.cliente = cliente;
		cliente.addPedido(this);
		itens = new ArrayList<>();
	}

	public BigDecimal valorTotal() {
		BigDecimal valorTotal = new BigDecimal("00.00");
		for (ItemPedido itemPedido : itens) {
			valorTotal = valorTotal.add(itemPedido.subTotal());
		}
		return valorTotal;
	}

	public void addItem(ItemPedido itemPedido) {
		this.itens.add(itemPedido);
		itemPedido.setPedido(this);
	}
	
	public void removeItem(ItemPedido itemPedido){
		this.itens.remove(itemPedido);
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPedido == null) ? 0 : codPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (codPedido == null) {
			if (other.codPedido != null)
				return false;
		} else if (!codPedido.equals(other.codPedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", data=" + data + "]";
	}
	
	
	
	

}

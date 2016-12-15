package com.sistemapizzaria.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_itemPizza")
public class ItemPizza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codItemPizza;
	
	@ManyToOne
	@JoinColumn(name="pizza")
	@JsonIgnore
	private Pizza pizza;
	
	@ManyToOne
	@JoinColumn(name="ingrediente")
	@JsonIgnore
	private Ingrediente ingrediente;

	public ItemPizza() {
	}

	public ItemPizza(Integer codItemPizza, Pizza pizza, Ingrediente ingrediente) {
		super();
		this.codItemPizza = codItemPizza;
		this.pizza = pizza;
		//pizza.addItemPizza(this);
		this.ingrediente = ingrediente;
		//ingrediente.addItem(this);
	}

	public Integer getCodItemPizza() {
		return codItemPizza;
	}

	public void setCodItemPizza(Integer codItemPizza) {
		this.codItemPizza = codItemPizza;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemPizza == null) ? 0 : codItemPizza.hashCode());
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
		ItemPizza other = (ItemPizza) obj;
		if (codItemPizza == null) {
			if (other.codItemPizza != null)
				return false;
		} else if (!codItemPizza.equals(other.codItemPizza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPizza [codItemPizza=" + codItemPizza + ", pizza=" + pizza + ", ingrediente=" + ingrediente + "]";
	}


	
	
	
	
	
	
	
	
	
	
}

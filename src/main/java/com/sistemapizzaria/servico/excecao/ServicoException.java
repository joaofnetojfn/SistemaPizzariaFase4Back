package com.sistemapizzaria.servico.excecao;

public class ServicoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private Integer cod;

	public ServicoException(Integer cod, String msg) {
		super(msg);
		this.cod = cod;
	}
	
	public Integer getCod() {
		return cod;
	}
	
}

package com.sistemapizzaria.servico.excecao;

public class NaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private int codigo;

	public NaoEncontradoException(String msg, int codigo) {
		super(msg);
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
}

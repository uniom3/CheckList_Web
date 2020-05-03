package com.mendonca.checklist.entities;

public enum Ativo {

	SIM(1, "SIM"),
	NAO(0, "NAO");
	
	private Integer numero;
	private String descricao;
	
	private Ativo(Integer numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}

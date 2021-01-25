package com.mendonca.checklist.entities.enums;

public enum TipoPessoa {
	
	
	PESSOAFISICA(01, "Pessoa Física"),
	PESSOAJURIDICA(02, "Pessoa Juridica");
		
	private Integer codigo;
	private String tipo;
	
	
	private TipoPessoa(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	

}

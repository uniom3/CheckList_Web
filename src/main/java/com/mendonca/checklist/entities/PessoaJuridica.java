package com.mendonca.checklist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOAJURIDICA")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;
	

	
	@Column(unique = true)
	private String cnpj;
	private String InscricaoMunicipal;
	private String InscricaoEstadual;
	private String razaoSocial;
	
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica( String cnpj, String inscricaoEstadual,String InscricaoMunicipal, String razaoSocial) {
		super();
		this.cnpj = cnpj;
		this.InscricaoEstadual = inscricaoEstadual;
		this.InscricaoMunicipal =InscricaoMunicipal;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return InscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		InscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getInscricaoMunicipal() {
		return InscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		InscricaoMunicipal = inscricaoMunicipal;
	}
	
	

}

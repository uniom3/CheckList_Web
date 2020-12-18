package com.mendonca.checklist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOAFISICA")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	
	@Column(unique = true)
	private String cpf;
	private String rg;
	private String orgaoEmissorRG;
	

	public PessoaFisica() {

	}

	public PessoaFisica(String cpf, String rg, String orgaoEmissorRG) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.orgaoEmissorRG = orgaoEmissorRG;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissorRG() {
		return orgaoEmissorRG;
	}

	public void setOrgaoEmissorRG(String orgaoEmissorRG) {
		this.orgaoEmissorRG = orgaoEmissorRG;
	}

}

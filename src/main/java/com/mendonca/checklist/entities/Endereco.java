package com.mendonca.checklist.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mendonca.checklist.entities.enums.UF;

@Entity
@Table(name ="TB_ENDERECO")
public class Endereco implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private UF uf;
	private String cep;
	private String pais;
	
	/*  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "TB_Pessoa_Endereco", 
	        joinColumns = { @JoinColumn(name = "pessoa_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "endereco_id") } )
	private List<Pessoa> pessoa;
	 
	
	public Endereco() {
		
	}
	
	public Endereco(Long id, String logradouro, String numero, String complemento, String bairro,String cidade, UF uf, String cep,
			String pais /*List<Pessoa> pessoa) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.pais = pais;
		//this.pessoa = pessoa;
	}

	
	
/*	
	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
*/
	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getcomplemento() {
		return complemento;
	}

	public void setcomplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	

}

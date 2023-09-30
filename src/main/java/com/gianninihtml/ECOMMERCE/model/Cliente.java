package com.gianninihtml.ECOMMERCE.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo_cliente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "inscricao_federal")
	private String inscricao_federal;
	
	@Column(name = "cep")
	private String cep;

	public Long getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Long codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInscricao_federal() {
		return inscricao_federal;
	}

	public void setInscricao_federal(String inscricao_federal) {
		this.inscricao_federal = inscricao_federal;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}

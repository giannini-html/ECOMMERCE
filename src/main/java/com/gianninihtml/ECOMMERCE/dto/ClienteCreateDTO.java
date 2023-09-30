package com.gianninihtml.ECOMMERCE.dto;

import com.gianninihtml.ECOMMERCE.model.Cliente;

public class ClienteCreateDTO {
	
	private Long codigo_cliente;
	private String nome;
	private String inscricao_federal;
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
	
	public static ClienteCreateDTO toDto(Cliente cliente) {
		ClienteCreateDTO dto = new ClienteCreateDTO();
		dto.setCodigo_cliente(cliente.getCodigo_cliente());
		dto.setNome(cliente.getNome());		
		dto.setCep(cliente.getCep());		
		dto.setInscricao_federal(cliente.getInscricao_federal());		
		return dto;
	}
}

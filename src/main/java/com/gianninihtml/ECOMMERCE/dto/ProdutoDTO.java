package com.gianninihtml.ECOMMERCE.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gianninihtml.ECOMMERCE.model.Produto;

public class ProdutoDTO {

	private Long codigo_produto;
	private String nome;
	private BigDecimal preco;
	private LocalDate data_validade;
	private LocalDate data_garantia;
	private boolean em_estoque;
	
	public Long getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(Long codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getData_validade() {
		return data_validade;
	}

	public void setData_validade(LocalDate data_validade) {
		this.data_validade = data_validade;
	}

	public LocalDate getData_garantia() {
		return data_garantia;
	}

	public void setData_garantia(LocalDate data_garantia) {
		this.data_garantia = data_garantia;
	}

	public boolean isEm_estoque() {
		return em_estoque;
	}

	public void setEm_estoque(boolean em_estoque) {
		this.em_estoque = em_estoque;
	}
	
	public static ProdutoDTO toDto(Produto produto) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setCodigo_produto(produto.getCodigo_produto());
		dto.setNome(produto.getNome());		
		dto.setPreco(produto.getPreco());		
		dto.setData_garantia(produto.getData_garantia());		
		dto.setData_validade(produto.getData_validade());		
		dto.setEm_estoque(produto.isEm_estoque());		
		return dto;
	}
}

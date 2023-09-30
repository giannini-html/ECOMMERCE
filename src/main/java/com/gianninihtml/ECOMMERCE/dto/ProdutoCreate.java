package com.gianninihtml.ECOMMERCE.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoCreate {

	private String nome;
	private BigDecimal preco;
	private LocalDate data_validade;
	private LocalDate data_garantia;
	private boolean em_estoque;

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
}

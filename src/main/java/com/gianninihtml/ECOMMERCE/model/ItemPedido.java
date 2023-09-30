package com.gianninihtml.ECOMMERCE.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
@SequenceGenerator(sequenceName = "ITENS_PEDIDO_SEQ", name = "ITENS_PEDIDO_SEQ")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long sequencia;
	
	@Column(name = "numero_pedido")
	private Long numero_pedido;
	
	@Column(name = "codigo_produto")
	private Long codigo_produto;
	
	@Column(name = "quantidade")
	private BigDecimal quantidade;
	
	@Column(name = "valor_total")
	private BigDecimal valor_total;

	public Long getSequencia() {
		return sequencia;
	}

	public void setSequencia(Long sequencia) {
		this.sequencia = sequencia;
	}

	public Long getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(Long numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public Long getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(Long codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
}

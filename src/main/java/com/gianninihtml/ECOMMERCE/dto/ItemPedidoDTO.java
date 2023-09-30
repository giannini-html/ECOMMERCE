package com.gianninihtml.ECOMMERCE.dto;

import java.math.BigDecimal;

import com.gianninihtml.ECOMMERCE.model.ItemPedido;

public class ItemPedidoDTO {
	
	private Long numero_pedido;
	private Long codigo_produto;
	private BigDecimal quantidade;
	private BigDecimal valor_total;
	
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
	
	public static ItemPedidoDTO toDto(ItemPedido itemPedido) {
		ItemPedidoDTO dto = new ItemPedidoDTO();
		dto.setCodigo_produto(itemPedido.getCodigo_produto());
		dto.setNumero_pedido(itemPedido.getNumero_pedido());		
		dto.setQuantidade(itemPedido.getQuantidade());		
		dto.setValor_total(itemPedido.getValor_total());		
		return dto;
	}
}

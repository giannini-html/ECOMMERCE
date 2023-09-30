package com.gianninihtml.ECOMMERCE.dto;

import java.time.LocalDate;

import com.gianninihtml.ECOMMERCE.model.Pedido;

public class PedidoCreate {

	private Long codigo_cliente;
	private LocalDate data_pedido;

	public Long getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Long codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public LocalDate getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(LocalDate data_pedido) {
		this.data_pedido = data_pedido;
	}
	
	public static PedidoCreate toDto(Pedido pedido) {
		PedidoCreate dto = new PedidoCreate();
		dto.setCodigo_cliente(pedido.getCodigo_cliente());
		dto.setData_pedido(pedido.getData_pedido());		
		return dto;
	}
}

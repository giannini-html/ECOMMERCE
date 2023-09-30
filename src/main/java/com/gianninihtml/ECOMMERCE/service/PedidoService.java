package com.gianninihtml.ECOMMERCE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gianninihtml.ECOMMERCE.model.Pedido;
import com.gianninihtml.ECOMMERCE.repository.PedidoRepository;

@Repository
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> list() {
		return pedidoRepository.findAll();
	}
	
	public Pedido save(Pedido pedido) {			
		return pedidoRepository.save(pedido);
	}
	
	public void delete(Pedido pedido) {			
		pedidoRepository.delete(pedido);
	}

}

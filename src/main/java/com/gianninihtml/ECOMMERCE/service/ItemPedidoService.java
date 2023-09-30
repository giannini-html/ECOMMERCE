package com.gianninihtml.ECOMMERCE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gianninihtml.ECOMMERCE.model.ItemPedido;
import com.gianninihtml.ECOMMERCE.repository.ItemPedidoRepository;

@Repository
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public List<ItemPedido> list() {
		return itemPedidoRepository.findAll();
	}
	
	public ItemPedido save(ItemPedido itemPedido) {			
		return itemPedidoRepository.save(itemPedido);
	}
	
	public void delete(ItemPedido itemPedido) {			
		itemPedidoRepository.delete(itemPedido);
	}
}

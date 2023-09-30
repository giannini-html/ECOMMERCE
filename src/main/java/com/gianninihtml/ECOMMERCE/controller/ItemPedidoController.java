package com.gianninihtml.ECOMMERCE.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianninihtml.ECOMMERCE.dto.ItemPedidoDTO;
import com.gianninihtml.ECOMMERCE.model.ItemPedido;
import com.gianninihtml.ECOMMERCE.repository.ItemPedidoRepository;
import com.gianninihtml.ECOMMERCE.service.ItemPedidoService;


@RestController
@RequestMapping("/itensPedidos")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	
	@GetMapping
	public List<ItemPedidoDTO> listAll() {
		List<ItemPedidoDTO> result = 
				itemPedidoService.list()
				.stream()
				.map(ItemPedidoDTO::toDto)
				.collect(Collectors.toList());
		return result;
	}

	@PostMapping
	public ItemPedido create(@RequestBody ItemPedidoDTO dto) {

		ItemPedido itemPedido = new ItemPedido();

		itemPedido.setCodigo_produto(dto.getCodigo_produto());
		itemPedido.setNumero_pedido(dto.getNumero_pedido());
		itemPedido.setQuantidade(dto.getQuantidade());
		itemPedido.setValor_total(dto.getValor_total());

		ItemPedido result = itemPedidoService.save(itemPedido);
		return result;
	}

	@PutMapping
	public ItemPedido update(@RequestBody ItemPedidoDTO dto) {

		if (!itemPedidoRepository.existsById(dto.getNumero_pedido())) {
			throw new RuntimeException("Pedido não encontrado " + dto.getNumero_pedido());
		}
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setCodigo_produto(dto.getCodigo_produto());
		itemPedido.setNumero_pedido(dto.getNumero_pedido());
		itemPedido.setQuantidade(dto.getQuantidade());
		itemPedido.setValor_total(dto.getValor_total());

		ItemPedido result = itemPedidoService.save(itemPedido);
		return result;
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		itemPedidoRepository.deleteById(id);
	}

}

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

import com.gianninihtml.ECOMMERCE.dto.PedidoDTO;
import com.gianninihtml.ECOMMERCE.model.Pedido;
import com.gianninihtml.ECOMMERCE.repository.PedidoRepository;
import com.gianninihtml.ECOMMERCE.service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoRepository pedidoRepository;

	
	@GetMapping
	public List<PedidoDTO> listAll() {
		List<PedidoDTO> result = 
				pedidoService.list()
				.stream()
				.map(PedidoDTO::toDto)
				.collect(Collectors.toList());
		return result;
	}

	@PostMapping
	public Pedido create(@RequestBody PedidoDTO dto) {

		Pedido pedido = new Pedido();

		pedido.setCodigo_cliente(dto.getCodigo_cliente());
		pedido.setData_pedido(dto.getData_pedido());

		Pedido result = pedidoService.save(pedido);
		return result;
	}

	@PutMapping
	public Pedido update(@RequestBody PedidoDTO dto) {

		if (!pedidoRepository.existsById(dto.getCodigo_cliente())) {
			throw new RuntimeException("Clinte não encontrado " + dto.getCodigo_cliente());
		}
		Pedido pedido = new Pedido();
		pedido.setCodigo_cliente(dto.getCodigo_cliente());
		pedido.setData_pedido(dto.getData_pedido());

		Pedido result = pedidoService.save(pedido);
		return result;
	}

	@DeleteMapping(value = "{numero_pedido}")
	public void delete(@PathVariable Long numero_pedido) {
		pedidoRepository.deleteById(numero_pedido);
	}

}

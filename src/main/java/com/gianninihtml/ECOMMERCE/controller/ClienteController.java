package com.gianninihtml.ECOMMERCE.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gianninihtml.ECOMMERCE.dto.ClienteCreateDTO;
import com.gianninihtml.ECOMMERCE.dto.ClienteDTO;
import com.gianninihtml.ECOMMERCE.model.Cliente;
import com.gianninihtml.ECOMMERCE.repository.ClienteRepository;
import com.gianninihtml.ECOMMERCE.service.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	
	@GetMapping
	public List<ClienteDTO> listAll() {
		List<ClienteDTO> result = 
				clienteService.list()
				.stream()
				.map(ClienteDTO::toDto)
				.collect(Collectors.toList());
		return result;
	}

	@GetMapping("/tabela")
	public String listAllClientesView(Model model) {
		List<ClienteDTO> result =
				clienteService.list()
						.stream()
						.map(ClienteDTO::toDto)
						.collect(Collectors.toList());
		model.addAttribute("clientes", result);
		return "clientes.html";
	}

	@GetMapping("/cadastro")
	public String cadastrarView(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cadastro.html";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ClienteDTO cliente, Model model) {

		Cliente clienteEntity = new Cliente();

		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setCep(cliente.getCep());
		clienteEntity.setInscricao_federal(cliente.getInscricao_federal());

		model.addAttribute("cliente", new Cliente());

		return "cadastro.html";
	}

	@PutMapping
	public Cliente update(@RequestBody ClienteCreateDTO dto) {

		if (!clienteRepository.existsById(dto.getCodigo_cliente())) {
			throw new RuntimeException("Clinte não encontrado " + dto.getCodigo_cliente());
		}
		Cliente cliente = new Cliente();
		cliente.setCodigo_cliente(dto.getCodigo_cliente());
		cliente.setNome(dto.getNome());
		cliente.setInscricao_federal(dto.getInscricao_federal());
		cliente.setCep(dto.getCep());

		Cliente result = clienteService.save(cliente);
		return result;
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}

}

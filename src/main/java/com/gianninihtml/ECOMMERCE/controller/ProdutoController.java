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

import com.gianninihtml.ECOMMERCE.dto.ProdutoCreate;
import com.gianninihtml.ECOMMERCE.dto.ProdutoDTO;
import com.gianninihtml.ECOMMERCE.model.Produto;
import com.gianninihtml.ECOMMERCE.repository.ProdutoRepository;
import com.gianninihtml.ECOMMERCE.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepository produtoRepository;

	
	@GetMapping
	public List<ProdutoDTO> listAll() {
		List<ProdutoDTO> result = 
				produtoService.list()
				.stream()
				.map(ProdutoDTO::toDto)
				.collect(Collectors.toList());
		return result;
	}

	@PostMapping
	public Produto create(@RequestBody ProdutoCreate dto) {

		Produto produto = new Produto();

		produto.setNome(dto.getNome());
		produto.setPreco(dto.getPreco());
		produto.setData_validade(dto.getData_validade());
		produto.setData_garantia(dto.getData_garantia());
		produto.setEm_estoque(dto.isEm_estoque());

		return produtoService.save(produto);
	}

	@PutMapping
	public Produto update(@RequestBody ProdutoDTO dto) {

		if (!produtoRepository.existsById(dto.getCodigo_produto())) {
			throw new RuntimeException("Clinte não encontrado " + dto.getCodigo_produto());
		}
		Produto produto = new Produto();
		produto.setCodigo_produto(dto.getCodigo_produto());
		produto.setNome(dto.getNome());
		produto.setPreco(dto.getPreco());
		produto.setData_garantia(dto.getData_garantia());
		produto.setData_validade(dto.getData_validade());
		produto.setEm_estoque(dto.isEm_estoque());

		return produtoService.save(produto);
	}

	@DeleteMapping(value = "{codigo_produto}")
	public void delete(@PathVariable Long codigo_produto) {
		produtoRepository.deleteById(codigo_produto);
	}

}

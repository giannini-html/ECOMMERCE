package com.gianninihtml.ECOMMERCE.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gianninihtml.ECOMMERCE.dto.ProdutoDTO;
import com.gianninihtml.ECOMMERCE.service.ProdutoService;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        List<ProdutoDTO> result =
                produtoService.list()
                        .stream()
                        .map(ProdutoDTO::toDto)
                        .collect(Collectors.toList());
        model.addAttribute("produtos", result);
        return "home.html";
    }

}

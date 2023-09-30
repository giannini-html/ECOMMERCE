package com.gianninihtml.ECOMMERCE.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {
	
	@Value("${mensagem}")
	private String mensagem;


    @GetMapping("/ping")
    public String ping() {
        return "ping pong: " + mensagem;
    }
}

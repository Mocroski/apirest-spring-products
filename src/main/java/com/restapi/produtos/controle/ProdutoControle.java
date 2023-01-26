package com.restapi.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.produtos.modelo.ProdutoModelo;
import com.restapi.produtos.servico.ProdutoServico;

@RestController
public class ProdutoControle {

	@Autowired
	private ProdutoServico ps;
	
	@GetMapping("/listar")
	public Iterable<ProdutoModelo> listar() {
		return ps.listar();
	}
	
	@GetMapping("/")
	public String rota() {
		return "API Funcionando";
	}
}
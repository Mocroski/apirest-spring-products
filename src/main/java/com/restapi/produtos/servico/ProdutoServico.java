package com.restapi.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.produtos.modelo.ProdutoModelo;
import com.restapi.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio pr;
	
	//metodo para listar produtos
	public Iterable<ProdutoModelo> listar(){
		return pr.findAll();
	}
}

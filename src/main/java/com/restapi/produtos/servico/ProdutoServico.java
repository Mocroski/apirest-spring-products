package com.restapi.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restapi.produtos.modelo.ProdutoModelo;
import com.restapi.produtos.modelo.RespostaModelo;
import com.restapi.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio pr;
	
	@Autowired
	private RespostaModelo rm;
	
	//metodo para listar produtos
	public Iterable<ProdutoModelo> listar(){
		return pr.findAll();
	}
	
	
	//metodo para cadastrar produtos
	public ResponseEntity<?> cadastrar(ProdutoModelo pm){
		
		if(pm.getNome().equals("")) {
			rm.setMensagem("O nome do produto é obrigatório");
			return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
		}else if(pm.getMarca().equals("")) {
			rm.setMensagem("O nome da marca é obrigátorio!");
			return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
		}
	}
	
}

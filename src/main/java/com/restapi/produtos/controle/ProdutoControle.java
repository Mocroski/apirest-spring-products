package com.restapi.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.produtos.modelo.ProdutoModelo;
import com.restapi.produtos.modelo.RespostaModelo;
import com.restapi.produtos.servico.ProdutoServico;

@RestController
@CrossOrigin(origins = "*")
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
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
		return ps.cadastrarAlterar(pm, "cadastrar");
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
		return ps.cadastrarAlterar(pm, "alterar");
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
		return ps.remover(codigo);
	}
}

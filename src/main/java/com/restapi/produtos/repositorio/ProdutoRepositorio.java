package com.restapi.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapi.produtos.modelo.ProdutoModelo;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long>{

}

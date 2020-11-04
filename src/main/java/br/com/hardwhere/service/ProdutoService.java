package br.com.hardwhere.service;

import java.util.List;

import br.com.hardwhere.dto.ProdutoRequest;
import br.com.hardwhere.entity.Produto;

public interface ProdutoService {
	
	List<Produto> findProdutos();

	Produto findProduto(Integer idProduto);

	Produto createProduto(ProdutoRequest pr);
	
	void updateProduto(Integer idProduto, ProdutoRequest pr);

	void deleteProduto(Integer idProduto);
	
}

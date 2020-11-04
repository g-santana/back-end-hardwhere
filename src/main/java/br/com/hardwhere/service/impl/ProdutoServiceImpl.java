package br.com.hardwhere.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hardwhere.dto.ProdutoRequest;
import br.com.hardwhere.entity.Produto;
import br.com.hardwhere.repository.ProdutoRepository;
import br.com.hardwhere.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Produto> findProdutos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto findProduto(Integer idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto createProduto(ProdutoRequest pr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduto(Integer idProduto, ProdutoRequest pr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduto(Integer idProduto) {
		// TODO Auto-generated method stub
		
	}

}

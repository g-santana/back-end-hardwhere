package br.com.hardwhere.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hardwhere.dto.PromocaoRequest;
import br.com.hardwhere.entity.Promocao;
import br.com.hardwhere.repository.PromocaoRepository;
import br.com.hardwhere.service.PromocaoService;

@Service
public class PromocaoServiceImpl implements PromocaoService {

	private final PromocaoRepository promocaoRepository;
	
	public PromocaoServiceImpl(PromocaoRepository promocaoRepository) {
		this.promocaoRepository = promocaoRepository;
	}
	
	@Override
	public List<Promocao> findPromocaos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promocao findPromocao(Integer idPromocao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promocao createPromocao(PromocaoRequest pr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePromocao(Integer idPromocao, PromocaoRequest pr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePromocao(Integer idPromocao) {
		// TODO Auto-generated method stub
		
	}

}

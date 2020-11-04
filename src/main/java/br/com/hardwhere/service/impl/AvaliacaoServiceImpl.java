package br.com.hardwhere.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hardwhere.dto.AvaliacaoRequest;
import br.com.hardwhere.entity.Avaliacao;
import br.com.hardwhere.repository.AvaliacaoRepository;
import br.com.hardwhere.service.AvaliacaoService;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	private final AvaliacaoRepository avaliacaoRepository;
	
	public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository) {
		this.avaliacaoRepository = avaliacaoRepository;
	}
	
	@Override
	public List<Avaliacao> findAvaliacaos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avaliacao findAvaliacao(Integer idAvaliacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avaliacao createAvaliacao(AvaliacaoRequest ar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAvaliacao(Integer idAvaliacao, AvaliacaoRequest ar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAvaliacao(Integer idAvaliacao) {
		// TODO Auto-generated method stub
		
	}

}

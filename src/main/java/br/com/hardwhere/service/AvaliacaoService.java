package br.com.hardwhere.service;

import java.util.List;

import br.com.hardwhere.dto.AvaliacaoRequest;
import br.com.hardwhere.entity.Avaliacao;

public interface AvaliacaoService {
	
	List<Avaliacao> findAvaliacaos();

	Avaliacao findAvaliacao(Integer idAvaliacao);

	Avaliacao createAvaliacao(AvaliacaoRequest pr);
	
	void updateAvaliacao(Integer idAvaliacao, AvaliacaoRequest pr);

	void deleteAvaliacao(Integer idAvaliacao);

}

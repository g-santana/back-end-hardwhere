package br.com.hardwhere.service;

import java.util.List;

import br.com.hardwhere.dto.PromocaoRequest;
import br.com.hardwhere.entity.Promocao;

public interface PromocaoService {
	
	List<Promocao> findPromocaos();

	Promocao findPromocao(Integer idPromocao);

	Promocao createPromocao(PromocaoRequest pr);
	
	void updatePromocao(Integer idPromocao, PromocaoRequest pr);

	void deletePromocao(Integer idPromocao);

}

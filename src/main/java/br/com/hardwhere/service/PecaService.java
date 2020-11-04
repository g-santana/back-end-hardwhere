package br.com.hardwhere.service;

import java.util.List;

import br.com.hardwhere.dto.PecaRequest;
import br.com.hardwhere.entity.Peca;

public interface PecaService {

	List<Peca> findPecas();

	Peca findPeca(Integer idPeca);

	Peca createPeca(PecaRequest pr);
	
	void updatePeca(Integer idPeca, PecaRequest pr);

	void deletePeca(Integer idPeca);
	
	//List<Peca> searchPecas(List<String> termos);
	
}

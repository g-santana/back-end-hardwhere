package br.com.hardwhere.service;

import java.util.List;

import br.com.hardwhere.entity.Loja;

public interface LojaService {
	
	List<Loja> findLojas();

	Loja findLoja(Integer idLoja);

	Loja createLoja(String nome);
	
	void updateLoja(Integer idLoja, String nomeLoja);

	void deleteLoja(Integer idLoja);
}

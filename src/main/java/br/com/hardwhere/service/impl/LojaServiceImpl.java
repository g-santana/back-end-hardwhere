package br.com.hardwhere.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.hardwhere.entity.Loja;
import br.com.hardwhere.repository.LojaRepository;
import br.com.hardwhere.service.LojaService;

@Service
public class LojaServiceImpl implements LojaService {

	private final LojaRepository lojaRepository;
	
	public LojaServiceImpl(LojaRepository lojaRepository) {
		this.lojaRepository = lojaRepository;
	}
	
	@Override
	public List<Loja> findLojas() {
		return this.lojaRepository.findAll();
	}

	@Override
	public Loja findLoja(Integer idLoja) {
		Optional<Loja> optLoja = this.lojaRepository.findById(idLoja);
		
		if(optLoja.isPresent()) {
			return optLoja.get();
		}
		
		return null;
	}

	@Override
	public Loja createLoja(String nome) {
		Loja loja = new Loja();
		loja.setNome(nome);
		return this.lojaRepository.save(loja);
	}

	@Override
	public void updateLoja(Integer idLoja, String nomeLoja) {
		Optional<Loja> optLoja = this.lojaRepository.findById(idLoja);
		
		if(optLoja.isPresent()) {
			Loja loja = optLoja.get();
			loja.setNome(nomeLoja);
			this.lojaRepository.save(loja);
		}
	}

	@Override
	public void deleteLoja(Integer idLoja) {
		this.lojaRepository.deleteById(idLoja);
	}

}

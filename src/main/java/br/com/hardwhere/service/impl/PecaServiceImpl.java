package br.com.hardwhere.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.hardwhere.dto.PecaRequest;
import br.com.hardwhere.entity.Peca;
import br.com.hardwhere.repository.PecaRepository;
import br.com.hardwhere.service.PecaService;

@Service
public class PecaServiceImpl implements PecaService {
	
	private final PecaRepository pecaRepository;
	
	public PecaServiceImpl(PecaRepository pecaRepository) {
		this.pecaRepository = pecaRepository;
	}

	@Override
	public List<Peca> findPecas() {
		return this.pecaRepository.findAll();
	}

	@Override
	public Peca findPeca(Integer idPeca) {
		Optional<Peca> optPeca = this.pecaRepository.findById(idPeca);
		
		if(optPeca.isPresent()) {
			return optPeca.get();
		}
		
		return null;
	}

	@Override
	public Peca createPeca(PecaRequest pr) {
		Peca peca = new Peca();
		peca.setFabricante(pr.fabricante);
		peca.setMarca(pr.marca);
		peca.setModelo(pr.modelo);
		peca.setTipo(pr.tipo);
		return this.pecaRepository.save(peca);
	}

	@Override
	public void updatePeca(Integer idPeca, PecaRequest pr) {
		Optional<Peca> optPeca = this.pecaRepository.findById(idPeca);
		
		if(optPeca.isPresent()) {
			Peca peca = optPeca.get();
			peca.setFabricante(pr.fabricante);
			peca.setMarca(pr.marca);
			peca.setModelo(pr.modelo);
			peca.setTipo(pr.tipo);
			this.pecaRepository.save(peca);
		}
	}

	@Override
	public void deletePeca(Integer idPeca) {
		this.pecaRepository.deleteById(idPeca);
	}
/*
	@Override
	public List<Peca> searchPecas(List<String> termos) {
		return this.pecaRepository.searchPecas(termos);
	}
*/
}

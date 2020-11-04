package br.com.hardwhere.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hardwhere.dto.FavoritoRequest;
import br.com.hardwhere.entity.Favorito;
import br.com.hardwhere.repository.FavoritoRepository;
import br.com.hardwhere.repository.PecaRepository;
import br.com.hardwhere.repository.UsuarioRepository;
import br.com.hardwhere.service.FavoritoService;

@Service
public class FavoritoServiceImpl implements FavoritoService {

	private final FavoritoRepository favoritoRepository;
	private final PecaRepository pecaRepository;
	private final UsuarioRepository usuarioRepository;
	
	public FavoritoServiceImpl(FavoritoRepository favoritoRepository, PecaRepository pecaRepository, UsuarioRepository usuarioRepository) {
		this.favoritoRepository = favoritoRepository;
		this.pecaRepository = pecaRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public List<Favorito> findFavoritos(Integer idUsuario) {
		List<Favorito> favoritos = this.favoritoRepository.findFavoritos(idUsuario);
		return favoritos;
	}

	@Override
	public Favorito createFavorito(FavoritoRequest fr) {
		Favorito f = new Favorito();
		f.setUsuario(this.usuarioRepository.findById(fr.idUsuario).get());
		f.getUsuario().setId(fr.idUsuario);
		f.setPeca(this.pecaRepository.findById(fr.idPeca).get());
		f.getPeca().setId(fr.idPeca);
		return this.favoritoRepository.save(f);
	}

	@Override
	public void deleteFavorito(Integer idFavorito) {
		this.favoritoRepository.deleteById(idFavorito);
	}

}

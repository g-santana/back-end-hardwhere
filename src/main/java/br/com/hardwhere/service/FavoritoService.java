package br.com.hardwhere.service;

import java.util.List;

import br.com.hardwhere.dto.FavoritoRequest;
import br.com.hardwhere.entity.Favorito;

public interface FavoritoService {
	
	List<Favorito> findFavoritos(Integer idUsuario);

	Favorito createFavorito(FavoritoRequest pr);
	
	void deleteFavorito(Integer idUsuario);

}

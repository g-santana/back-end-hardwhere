package br.com.hardwhere.web.rest;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hardwhere.dto.FavoritoRequest;
import br.com.hardwhere.entity.Favorito;
import br.com.hardwhere.service.FavoritoService;

@Configuration
@RestController
@RequestMapping(value = "/favoritos", produces = MediaType.APPLICATION_JSON_VALUE)
public class FavoritoRestController {

	private final FavoritoService favoritoService;
	
	public FavoritoRestController(FavoritoService favoritoService) {
		this.favoritoService = favoritoService;
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<Favorito>> getFavoritos(@PathVariable("id") Integer idUsuario) {
		try {
			List<Favorito> favoritos = this.favoritoService.findFavoritos(idUsuario);
			return new ResponseEntity<>(favoritos, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Favorito> createFavorito(@RequestBody FavoritoRequest pr) {
		try {
			Favorito favorito = this.favoritoService.createFavorito(pr);
			return new ResponseEntity<>(favorito, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFavorito(@PathVariable("id") Integer idFavorito) {
		try {
			this.favoritoService.deleteFavorito(idFavorito);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

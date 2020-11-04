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

import br.com.hardwhere.dto.LojaRequest;
import br.com.hardwhere.entity.Loja;
import br.com.hardwhere.service.LojaService;

@Configuration
@RestController
@RequestMapping(value = "/lojas", produces = MediaType.APPLICATION_JSON_VALUE)
public class LojaRestController {
	
	private final LojaService lojaService;
	
	public LojaRestController(LojaService lojaService) {
		this.lojaService = lojaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Loja> getLoja(@PathVariable("id") Integer idLoja) {
		try {
			Loja loja = this.lojaService.findLoja(idLoja);
			return new ResponseEntity<>(loja, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Loja>> getLojas() {
		try {
			List<Loja> lojas = this.lojaService.findLojas();
			return new ResponseEntity<>(lojas, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Loja> createLoja(@RequestBody LojaRequest lr) {
		try {
			Loja loja = this.lojaService.createLoja(lr.nome);
			return new ResponseEntity<>(loja, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateLoja(@PathVariable("id") Integer idLoja, @RequestBody LojaRequest lr) {
		try {
			this.lojaService.updateLoja(idLoja, lr.nome);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLoja(@PathVariable("id") Integer idLoja) {
		try {
			this.lojaService.deleteLoja(idLoja);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}

package br.com.hardwhere.web.rest;

import java.util.Arrays;
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

import br.com.hardwhere.dto.PecaRequest;
import br.com.hardwhere.dto.PecaSearchRequest;
import br.com.hardwhere.entity.Peca;
import br.com.hardwhere.service.PecaService;

@Configuration
@RestController
@RequestMapping(value = "/pecas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PecaRestController {

	private final PecaService pecaService;
	
	public PecaRestController(PecaService pecaService) {
		this.pecaService = pecaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Peca> getPeca(@PathVariable("id") Integer idPeca) {
		try {
			Peca peca = this.pecaService.findPeca(idPeca);
			return new ResponseEntity<>(peca, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Peca>> getPecas() {
		try {
			List<Peca> pecas = this.pecaService.findPecas();
			return new ResponseEntity<>(pecas, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Peca> createPeca(@RequestBody PecaRequest pr) {
		try {
			Peca peca = this.pecaService.createPeca(pr);
			return new ResponseEntity<>(peca, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updatePeca(@PathVariable("id") Integer idPeca, @RequestBody PecaRequest pr) {
		try {
			this.pecaService.updatePeca(idPeca, pr);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePeca(@PathVariable("id") Integer idPeca) {
		try {
			this.pecaService.deletePeca(idPeca);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	/*
	@PostMapping("/search")
	public ResponseEntity<List<Peca>> searchPecas(@RequestBody PecaSearchRequest psr) {
		try {
			List<Peca> pecas = this.pecaService.searchPecas(Arrays.asList(psr.busca.split(" ")));
			return new ResponseEntity<>(pecas, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}*/

}

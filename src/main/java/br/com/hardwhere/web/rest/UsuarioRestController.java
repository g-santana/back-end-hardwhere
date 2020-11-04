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

import br.com.hardwhere.dto.UsuarioAuthRequest;
import br.com.hardwhere.dto.UsuarioAuthResponse;
import br.com.hardwhere.dto.UsuarioRequest;
import br.com.hardwhere.entity.Usuario;
import br.com.hardwhere.service.UsuarioService;

@Configuration
@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioRestController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Integer idUsuario) {
		try {
			Usuario usuario = this.usuarioService.findUsuario(idUsuario);
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		try {
			List<Usuario> usuarios = this.usuarioService.findUsuarios();
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioRequest ur) {
		try {
			Usuario usuario = this.usuarioService.createUsuario(ur);
			return new ResponseEntity<>(usuario, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateUsuario(@PathVariable("id") Integer idUsuario, @RequestBody UsuarioRequest ur) {
		try {
			this.usuarioService.updateUsuario(idUsuario, ur);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Integer idUsuario) {
		try {
			this.usuarioService.deleteUsuario(idUsuario);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/auth")
	public ResponseEntity<UsuarioAuthResponse> authUsuario(@RequestBody UsuarioAuthRequest uar) {
		try {
			UsuarioAuthResponse response = this.usuarioService.authUsuario(uar);

			if(response.authorized || response.authorizedAsAdmin) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

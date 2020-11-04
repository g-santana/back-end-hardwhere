package br.com.hardwhere.service.impl;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import br.com.hardwhere.dto.UsuarioAuthRequest;
import br.com.hardwhere.dto.UsuarioAuthResponse;
import br.com.hardwhere.dto.UsuarioRequest;
import br.com.hardwhere.entity.Usuario;
import br.com.hardwhere.repository.UsuarioRepository;
import br.com.hardwhere.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

private final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuario> findUsuarios() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario findUsuario(Integer idUsuario) {
		Optional<Usuario> optUsuario = this.usuarioRepository.findById(idUsuario);
		
		if(optUsuario.isPresent()) {
			return optUsuario.get();
		}
		
		return null;
	}

	@Override
	public Usuario createUsuario(UsuarioRequest ur) {
		Usuario usuario = new Usuario();
		usuario.setEmail(ur.email);
		usuario.setSenha(DigestUtils.sha256Hex(ur.senha));
		usuario.setNome(ur.nome);
		usuario.setIsAdmin(0);
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public void updateUsuario(Integer idUsuario, UsuarioRequest ur) {
		Optional<Usuario> optUsuario = this.usuarioRepository.findById(idUsuario);
		
		if(optUsuario.isPresent()) {
			Usuario usuario = optUsuario.get();
			usuario.setEmail(ur.email);
			usuario.setSenha(DigestUtils.sha256Hex(ur.senha));
			usuario.setNome(ur.nome);
			this.usuarioRepository.save(usuario);
		}
	}

	@Override
	public void deleteUsuario(Integer idUsuario) {
		this.usuarioRepository.deleteById(idUsuario);
	}

	@Override
	public UsuarioAuthResponse authUsuario(UsuarioAuthRequest uar) {
		Usuario usuario = this.usuarioRepository.findByEmail(uar.email);
		UsuarioAuthResponse response = new UsuarioAuthResponse();
		response.authorized = false;
		response.authorizedAsAdmin = false;
		
		if(nonNull(usuario) && (DigestUtils.sha256Hex(uar.senha).equals(usuario.getSenha()))) {
			response.authorized = true;
			
			if(usuario.getIsAdmin().equals(1)) {
				response.authorizedAsAdmin = true;
			}
		}
		
		return response;
	}

}

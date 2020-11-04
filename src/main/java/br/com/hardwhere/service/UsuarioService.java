package br.com.hardwhere.service;

import java.util.List;

import br.com.hardwhere.dto.UsuarioAuthRequest;
import br.com.hardwhere.dto.UsuarioAuthResponse;
import br.com.hardwhere.dto.UsuarioRequest;
import br.com.hardwhere.entity.Usuario;

public interface UsuarioService {

	List<Usuario> findUsuarios();

	Usuario findUsuario(Integer idUsuario);

	Usuario createUsuario(UsuarioRequest ur);
	
	void updateUsuario(Integer idUsuario, UsuarioRequest ur);

	void deleteUsuario(Integer idUsuario);

	UsuarioAuthResponse authUsuario(UsuarioAuthRequest uar);
	
}

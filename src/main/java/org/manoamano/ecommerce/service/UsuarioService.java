package org.manoamano.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.manoamano.ecommerce.dto.ClaveDto;
import org.manoamano.ecommerce.model.Usuario;
import org.manoamano.ecommerce.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	final private UsuariosRepository usuariosRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	public UsuarioService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}// Constructor

	public List<Usuario> getUsuarios() {
		return usuariosRepository.findAll();
	}// getUsuarios

	public Usuario getUsuario(Long id) {

		return usuariosRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("El usuario con el id [" + id + "] no existe."));
	}// getUsuario

	public Usuario deleteUsuario(Long id) {

		Usuario tmpUsuario = null;

		if (usuariosRepository.existsById(id)) {
			tmpUsuario = usuariosRepository.findById(id).get();
			usuariosRepository.deleteById(id);
		}

		return tmpUsuario;
	}// deleteUsuario

	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> user = usuariosRepository.findByCorreo(usuario.getCorreo());

		if (user.isEmpty()) {
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			usuariosRepository.save(usuario);
		} else {
			usuario = null;
		}

		return usuario;

	}// addUsuario

	public Usuario updateUsuario(Long id, ClaveDto claveDto) {
		Usuario tmpUsuario = usuariosRepository.findById(id).get();

		//tmpUsuario.getClave().equals( claveDto.getClave()
		if (encoder.matches(claveDto.getClave(), tmpUsuario.getPassword())) {
			tmpUsuario.setPassword(encoder.encode(claveDto.getNclave()));
			return usuariosRepository.save(tmpUsuario);
		} else {
			tmpUsuario = null;
		} // else

		return tmpUsuario;
	}// updateUsuario

	public boolean validarUsuario(Usuario usuario) {

		Optional<Usuario> user = usuariosRepository.findByCorreo(usuario.getCorreo());
		Usuario tmpUsuario = null;

		if (user.isPresent()) {
			tmpUsuario = user.get();

			if (encoder.matches(usuario.getPassword(), tmpUsuario.getPassword())) {
				return true;
			}
		} // if

		return false;
	}

}// UsuarioService
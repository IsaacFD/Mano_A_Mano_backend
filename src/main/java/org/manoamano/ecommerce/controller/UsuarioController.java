package org.manoamano.ecommerce.controller;

import java.util.List;


import org.manoamano.ecommerce.dto.ClaveDto;
import org.manoamano.ecommerce.model.Usuario;
import org.manoamano.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ecommerce/usuarios/")
@CrossOrigin (origins="https://mano-a-mano-frontend.vercel.app/")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}// Constructor

	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuarioService.getUsuarios();
	}// getUsuarios

	@GetMapping(path = "{usuarioId}")
	public Usuario getUsuario(@PathVariable("usuarioId") Long id) {
		return usuarioService.getUsuario(id);
	}// getUsuario

	@DeleteMapping(path = "{usuarioId}")
	public Usuario deleteUsuario(@PathVariable("usuarioId") Long id) {
		return usuarioService.deleteUsuario(id);
	}// deleteUsuario

	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}// addUsuario

	@PutMapping(path = "{usuarioId}")
	public Usuario updateUsuario(@PathVariable("usuarioId") Long id, @RequestBody(required = true) ClaveDto claveDto) {

		return usuarioService.updateUsuario(id, claveDto);

	}// updateUsuario

}// UsuarioController

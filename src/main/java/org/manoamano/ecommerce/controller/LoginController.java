package org.manoamano.ecommerce.controller;

import java.util.Calendar;

import java.util.Date;

import org.manoamano.ecommerce.config.JwtFilter;
import org.manoamano.ecommerce.dto.TokenAcceso;
import org.manoamano.ecommerce.model.Usuario;
import org.manoamano.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping(path = "/ecommerce/login/")
@CrossOrigin (origins="https://mano-a-mano-frontend.vercel.app/")
public class LoginController {

	private final UsuarioService usuarioService;

	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}// Constructor

	@PostMapping
	public TokenAcceso loginUsuario(@RequestBody Usuario usuario) throws ServletException {
		if (usuarioService.validarUsuario(usuario)) {
			return new TokenAcceso(generarToken(usuario.getCorreo()));
		} // if

		throw new ServletException(" El correo o contraseña son incorrectos [" + usuario.getCorreo() + "].");
	}// loginUsuario

	private String generarToken(String email) {
		Calendar calendar = Calendar.getInstance();
		// calendar.add( Calendar.MINUTE , 5); Ixquanok
		calendar.add(Calendar.HOUR, 24); // Testinho

		return Jwts.builder().subject(email).claim("role", "user").issuedAt(new Date()).expiration(calendar.getTime())
				.signWith(JwtFilter.getSigninKey()).compact();
	}// generarToken

}// class LoginController
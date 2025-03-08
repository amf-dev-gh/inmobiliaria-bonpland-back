package com.andres.inmobiliariaBonpland.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.andres.inmobiliariaBonpland.model.Usuario;
import com.andres.inmobiliariaBonpland.model.dto.LoginUsuarioDto;
import com.andres.inmobiliariaBonpland.model.dto.RegistroUsuarioDto;
import com.andres.inmobiliariaBonpland.model.responses.LoginResponse;
import com.andres.inmobiliariaBonpland.service.implement.AuthenticationService;
import com.andres.inmobiliariaBonpland.service.implement.JwtService;

/**
 * Controlador REST para la gestión de usuarios de la BBDD.
 * 
 * @author Andres Mariano Fernández
 */
@RestController
@RequestMapping("/api/bonpland/usuarios")
public class UsuarioController {

	private final JwtService jwtService;

	private final AuthenticationService authService;

	public UsuarioController(JwtService jwtService, AuthenticationService authService) {
		this.jwtService = jwtService;
		this.authService = authService;
	}

	/**
	 * Metodo para registrar un usuario nuevo en la DDBB con los datos recibidos.
	 * 
	 * @param registroUsuario
	 * @return Retorna el nuevo usuario registrado con su información.
	 * @author Andres Mariano Fernández
	 */
	@PostMapping("/registrar")
	public ResponseEntity<Usuario> register(@RequestBody RegistroUsuarioDto registroUsuario) {
		Usuario usuarioRegistrado = authService.registrar(registroUsuario);
		return new ResponseEntity<>(usuarioRegistrado, HttpStatus.OK);
	}

	/**
	 * Metodo para iniciar sesión y generar el token de validación.
	 * 
	 * @param login
	 * @return Retorna un LoginResponse con el token, tiempo de expiración y el rol
	 *         del usuario logueado. Caso contrario retorna excepción de usuario no
	 *         autenticado.
	 * @author Andres Mariano Fernández
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticar(@RequestBody LoginUsuarioDto login) {
		Usuario authenticatedUser = authService.autenticar(login);
		String jwtToken = jwtService.generateToken(authenticatedUser);
		LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime(),
				authenticatedUser.getRol());
		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}

}

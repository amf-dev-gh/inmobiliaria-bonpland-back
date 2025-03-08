package com.andres.inmobiliariaBonpland.service.implement;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.andres.inmobiliariaBonpland.model.Usuario;
import com.andres.inmobiliariaBonpland.model.dto.LoginUsuarioDto;
import com.andres.inmobiliariaBonpland.model.dto.RegistroUsuarioDto;
import com.andres.inmobiliariaBonpland.repository.UsuarioRepository;

/*
 * Servicio encargado de la autenticacion, creación y persistencia de los usuarios en la BBDD
 * 
 * @author Andres Mariano Fernández
 */
@Service
public class AuthenticationService {

	private final UsuarioRepository usuarioRepo;

	private final PasswordEncoder passEncoder;

	private final AuthenticationManager authManager;

	public AuthenticationService(UsuarioRepository usuarioRepo, AuthenticationManager authManager,
			PasswordEncoder passEncoder) {
		this.authManager = authManager;
		this.usuarioRepo = usuarioRepo;
		this.passEncoder = passEncoder;
	}

	public Usuario registrar(RegistroUsuarioDto input) {
		Usuario usuario = new Usuario();
		usuario.setNombre(input.getNombre());
		usuario.setUsername(input.getUsername());
		usuario.setPassword(passEncoder.encode(input.getPassword()));
		usuario.setRol(input.getRol());
		usuario.setEmail(input.getEmail());
		return usuarioRepo.save(usuario);
	}

	public Usuario autenticar(LoginUsuarioDto input) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword()));
		return usuarioRepo.findByUsername(input.getUsername()).orElseThrow();
	}
}
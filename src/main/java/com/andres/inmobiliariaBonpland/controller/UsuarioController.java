package com.andres.inmobiliariaBonpland.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.inmobiliariaBonpland.model.Credenciales;
import com.andres.inmobiliariaBonpland.model.Usuario;
import com.andres.inmobiliariaBonpland.service.UsuarioService;

@RestController
@RequestMapping("/api/bonpland/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/autenticar")
	public ResponseEntity<?> autenticarUsuario(@RequestBody Credenciales credenciales){
		Optional<Usuario> usuarioAutenticadoOpt = usuarioService.obtenerUsuarioAutenticado(credenciales);
		if (usuarioAutenticadoOpt.isEmpty()) {
			return new ResponseEntity<>("El usuario o contraseña son incorrectos", HttpStatus.OK);			
		}
		return new ResponseEntity<>(usuarioAutenticadoOpt.get(), HttpStatus.OK);
	}

}

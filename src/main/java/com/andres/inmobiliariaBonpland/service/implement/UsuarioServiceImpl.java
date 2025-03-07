package com.andres.inmobiliariaBonpland.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.inmobiliariaBonpland.model.Credenciales;
import com.andres.inmobiliariaBonpland.model.Usuario;
import com.andres.inmobiliariaBonpland.repository.UsuarioRepository;
import com.andres.inmobiliariaBonpland.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepo;

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepo.save(usuario);
	}

	@Override
	public Optional<Usuario> obtenerUsuarioAutenticado(Credenciales credenciales) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findByUsername(credenciales.getUsername());
		if(usuarioOpt.isPresent()) {
			if (credenciales.getPassword().equals(usuarioOpt.get().getPassword())) {
				return usuarioOpt;
			}
		}
		return Optional.empty();
	}

}

package com.andres.inmobiliariaBonpland.service;

import java.util.Optional;
import com.andres.inmobiliariaBonpland.model.Credenciales;
import com.andres.inmobiliariaBonpland.model.Usuario;

public interface UsuarioService{
	
	public void guardar(Usuario usuario);

	Optional<Usuario> obtenerUsuarioAutenticado(Credenciales credenciales);

}

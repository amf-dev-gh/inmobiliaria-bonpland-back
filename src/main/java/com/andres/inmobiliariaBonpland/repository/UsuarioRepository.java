package com.andres.inmobiliariaBonpland.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.inmobiliariaBonpland.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsername(String nombreDeUsuario);

}

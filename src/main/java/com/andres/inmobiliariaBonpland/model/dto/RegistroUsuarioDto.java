package com.andres.inmobiliariaBonpland.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 * Data que recibe el metodo para registrar un nuevo usuario en la BBDD.
 */
@Getter
@Setter
@AllArgsConstructor
public class RegistroUsuarioDto {

	private String username;

	private String password;

	private String nombre;

	private String email;

	private String rol;

}

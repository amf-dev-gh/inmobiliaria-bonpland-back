package com.andres.inmobiliariaBonpland.model.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Data que recibe el metodo para iniciar sesión.
 */
@Getter
@Setter
public class LoginUsuarioDto {

	private String username;

	private String password;

}

package com.andres.inmobiliariaBonpland.model.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 * Data que se envia como respuesta al loguearse en la API.
 */
@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

	private String token;

	private long expiracion;

	private String rol;

}
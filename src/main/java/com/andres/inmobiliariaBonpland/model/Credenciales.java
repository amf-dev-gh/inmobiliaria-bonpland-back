package com.andres.inmobiliariaBonpland.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Credenciales {
	
	private String username;
	private String password;
	
	
	@Override
	public String toString() {
		return "Credenciales [username=" + username + ", contraseña=" + password + "]";
	}
	
	

}

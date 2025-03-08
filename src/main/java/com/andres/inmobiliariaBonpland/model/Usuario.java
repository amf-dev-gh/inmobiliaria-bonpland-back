package com.andres.inmobiliariaBonpland.model;

import java.util.Collection;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad de tipo usuario para persistencia en BBDD.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nombre;
	@Column(unique = true, length = 100, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String rol;
	@CreationTimestamp
	@Column(updatable = false, name = "fecha_creacion")
	private Date creado;
	@UpdateTimestamp
	@Column(name = "fecha_modificacion")
	private Date modificado;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", password=" + password
				+ ", mail=" + email + ", rol=" + rol + ", creado el=" + creado + ", modificado el=" + modificado + "]";
	}

}

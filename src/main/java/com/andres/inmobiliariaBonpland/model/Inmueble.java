package com.andres.inmobiliariaBonpland.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad de tipo inmueble para persistencia en la BBDD.
 * 
 */
@Entity
@Table(name = "Inmuebles")
@Data
@NoArgsConstructor
public class Inmueble {

	@Id
	private String id;
	@Column(nullable = false)
	private String pais;
	@Column(nullable = false)
	private String ciudad;
	private String barrio;
	@Column(nullable = false)
	private Integer metrosCuadrados;
	@Column(nullable = false)
	private int cantAmbientes;
	@Column(nullable = false)
	private String tipoDeContratacion;
	@Column(nullable = false)
	private Integer costo;
	@Column(nullable = false)
	private String estado;
	@Column(nullable = false)
	private String imgUrl;
	@Column(nullable = false)
	private LocalDate fechaCreacion;
	@Column(nullable = false)
	private LocalDate fechaModificacion;
	private String infoAdicional;

	@Override
	public String toString() {
		return "Inmueble [id=" + id + ", cantidad ambientes=" + cantAmbientes + ", pais=" + pais + ", ciudad=" + ciudad
				+ ", barrio=" + barrio + ", costo=" + costo + ", metros2=" + metrosCuadrados + ", tipoDeContratacion="
				+ tipoDeContratacion + ", estado=" + estado + "]";
	}

	public Inmueble(String pais, String ciudad, String barrio, Integer metrosCuadrados, int cantAmbientes,
			String tipoDeContratacion, Integer costo, String estado, String imgUrl, String infoAdicional) {
		this.pais = pais;
		this.ciudad = ciudad;
		this.barrio = barrio;
		this.metrosCuadrados = metrosCuadrados;
		this.cantAmbientes = cantAmbientes;
		this.tipoDeContratacion = tipoDeContratacion;
		this.costo = costo;
		this.estado = estado;
		this.imgUrl = imgUrl;
		this.infoAdicional = infoAdicional;
	}

}

package com.andres.inmobiliariaBonpland.model.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Data que recibe el metodo para filtrar los inmuebles almacenados en la BBDD.
 */
@Getter
@Setter
public class FiltroInmueble {

	private String pais;
	private String ciudad;
	private String barrio;
	private Integer cantidadAmbientesMin;
	private Integer cantidadAmbientesMax;
	private Integer costoMinimo;
	private Integer costoMaximo;
	private Integer metrosMinimos;
	private Integer metrosMaximos;
	private String tipoDeContratacion;

	@Override
	public String toString() {
		return "FiltroInmueble [pais=" + pais + ", ciudad=" + ciudad + ", barrio=" + barrio + ", cantidadAmbientesMax="
				+ cantidadAmbientesMax + ", cantidadAmbientesMin=" + cantidadAmbientesMin + ", costoMinimo="
				+ costoMinimo + ", costoMaximo=" + costoMaximo + ", metrosMinimos=" + metrosMinimos + ", metrosMaximos="
				+ metrosMaximos + ", tipoDeContratacion=" + tipoDeContratacion + "]";
	}

}

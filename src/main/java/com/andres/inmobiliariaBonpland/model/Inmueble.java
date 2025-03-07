package com.andres.inmobiliariaBonpland.model;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Inmuebles")
@Data
public class Inmueble {

	@Id
	private String id;
	private String pais;
	private String ciudad;
	private String barrio;
	private Integer metrosCuadrados;
	private int cantAmbientes;
	private String tipoDeContratacion;
	private Integer costo;
	private String estado;
	private String imgUrl;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private String infoAdicional;
	
	//PARA UTILIZAR EL ID DE TIPO STRING
    public Inmueble() {
        this.id = UUID.randomUUID().toString().replace("-", "");
    }

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

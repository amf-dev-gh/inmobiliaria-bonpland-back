package com.andres.inmobiliariaBonpland.service;

import java.util.List;
import java.util.Optional;

import com.andres.inmobiliariaBonpland.model.Inmueble;
import com.andres.inmobiliariaBonpland.model.dto.FiltroInmueble;

public interface InmuebleService {

	public List<Inmueble> getAll();

	public Inmueble save(Inmueble inmueble);

	public boolean delete(String id);

	List<Inmueble> filtrarInmuebles(FiltroInmueble filtro);

	public Optional<Inmueble> findById(String id);

}

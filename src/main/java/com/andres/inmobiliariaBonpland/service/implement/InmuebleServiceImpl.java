package com.andres.inmobiliariaBonpland.service.implement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andres.inmobiliariaBonpland.model.Inmueble;
import com.andres.inmobiliariaBonpland.repository.InmuebleRepository;
import com.andres.inmobiliariaBonpland.service.InmuebleService;
import com.andres.inmobiliariaBonpland.utils.FiltroInmueble;

@Service
public class InmuebleServiceImpl implements InmuebleService {

	@Autowired
	InmuebleRepository inmuebleRepo;

	@Override
	public List<Inmueble> getAll() {
		return inmuebleRepo.findAll();
	}
	
	public Inmueble save(Inmueble inmueble) {
		LocalDate fechaActual = LocalDate.now();
		inmueble.setFechaModificacion(fechaActual);	
		
		if(inmueble.getId() == null || inmueble.getId().isEmpty()) {
			inmueble.setId(UUID.randomUUID().toString().replace("-", ""));
			inmueble.setFechaCreacion(fechaActual);
		}else {
			Optional<Inmueble> opt = findById(inmueble.getId());
			inmueble.setFechaCreacion(opt.get().getFechaCreacion());
		}
		
		return inmuebleRepo.save(inmueble);
	}

	@Override
	public boolean delete(String id) {
		Optional<Inmueble> inmuebleAEliminar = inmuebleRepo.findById(id);
		if (inmuebleAEliminar.isPresent()) {
			inmuebleRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Inmueble> filtrarInmuebles(FiltroInmueble filtro) {
		return inmuebleRepo.filtrarInmuebles(filtro.getPais(), filtro.getCiudad(), filtro.getBarrio(),
				filtro.getCantidadAmbientesMin(), filtro.getCantidadAmbientesMax(), filtro.getCostoMinimo(),
				filtro.getCostoMaximo(), filtro.getMetrosMinimos(), filtro.getMetrosMaximos(),
				filtro.getTipoDeContratacion());
	}

	@Override
	public Optional<Inmueble> findById(String id) {
		return inmuebleRepo.findById(id);
	}

}

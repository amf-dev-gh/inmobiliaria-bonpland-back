package com.andres.inmobiliariaBonpland.controller;

import org.springframework.web.bind.annotation.RestController;

import com.andres.inmobiliariaBonpland.model.Inmueble;
import com.andres.inmobiliariaBonpland.service.InmuebleService;
import com.andres.inmobiliariaBonpland.utils.FiltroInmueble;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/bonpland/inmuebles")
@CrossOrigin(origins = "http://localhost:4200")
public class InmuebleController {

	@Autowired
	private InmuebleService inmuebleService;

	private static final Logger log = LogManager.getLogger(Log4jLogEvent.class);

	@GetMapping("/listar")
	public ResponseEntity<?> getInmuebles() {
		List<Inmueble> listadoInmuebles = inmuebleService.getAll();
		if (listadoInmuebles.isEmpty()) {
			log.warn("El listado de inmuebles se encuentra vacio.");
		}
		return new ResponseEntity<>(listadoInmuebles, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getInmuebleById(@PathVariable String id) {
		Optional<Inmueble> inmuebleOpt = inmuebleService.findById(id);
		if (inmuebleOpt.isPresent()) {
			log.warn("Se encontro el inmueble: " + inmuebleOpt.get());
			return new ResponseEntity<>(inmuebleOpt.get(), HttpStatus.OK);
		}
		log.info("No se encontraron inmuebles con el id : " + id);
		return new ResponseEntity<>("No se encontraron inmuebles con el id : " + id, HttpStatus.OK);
	}

	@PostMapping("/filtrar")
	public ResponseEntity<?> filtrarInmuebles(@RequestBody FiltroInmueble filtro) {
		List<Inmueble> inmueblesFiltrados = inmuebleService.filtrarInmuebles(filtro);
		if (inmueblesFiltrados.isEmpty()) log.info("No hay inmuebles con los Valores ingresados");
		return new ResponseEntity<>(inmueblesFiltrados, HttpStatus.OK);
	}
	

	@PostMapping("/guardar")
	public ResponseEntity<?> guardarInmueble(@RequestBody Inmueble inmueble) {
		System.out.println("llego el inmueble " + inmueble);			
		return new ResponseEntity<>(inmuebleService.save(inmueble), HttpStatus.OK);
	}

	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarInmueble(@PathVariable String id) {
		boolean eliminado = inmuebleService.delete(id);
		if (eliminado)
			return new ResponseEntity<>(eliminado, HttpStatus.OK);
		return new ResponseEntity<>("El inmueble con id: " + id + " no existe o no se ha podido eliminar.",
				HttpStatus.OK);
	}

}

package com.andres.inmobiliariaBonpland.controller;

import org.springframework.web.bind.annotation.RestController;

import com.andres.inmobiliariaBonpland.model.Inmueble;
import com.andres.inmobiliariaBonpland.model.dto.FiltroInmueble;
import com.andres.inmobiliariaBonpland.service.InmuebleService;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controlador REST para la gestión CRUD de inmuebles
 *
 * @author Andres Mariano Fernández
 */
@RestController
@RequestMapping("/api/bonpland/inmuebles")
public class InmuebleController {

	private final InmuebleService inmuebleService;

	public InmuebleController(InmuebleService inmuebleService) {
		this.inmuebleService = inmuebleService;
	}

	private static final Logger log = LogManager.getLogger(Log4jLogEvent.class);

	/**
	 * Metodo para listar todos los inmuebles
	 * 
	 * @return Retorna una lista de todos los inmuebles registrados en la BBDD
	 * @author Andres Mariano Fernández
	 */
	@GetMapping("/listar")
	public ResponseEntity<List<Inmueble>> getInmuebles() {
		List<Inmueble> listadoInmuebles = inmuebleService.getAll();
		return new ResponseEntity<>(listadoInmuebles, HttpStatus.OK);
	}

	/**
	 * Metodo para obtener informacion de un inmueble especificando su ID.
	 * 
	 * @param id
	 * @return Retorna detalles del inmueble encontrado. Caso contrario mensaje de
	 *         error.
	 * @author Andres Mariano Fernández
	 */
	@GetMapping("/detalle/{id}")
	public ResponseEntity<?> getInmuebleById(@PathVariable String id) {
		Optional<Inmueble> inmuebleOpt = inmuebleService.findById(id);
		if (inmuebleOpt.isPresent()) {
			return new ResponseEntity<>(inmuebleOpt.get(), HttpStatus.OK);
		}
		log.info("No se encontraron inmuebles con el id : " + id);
		return new ResponseEntity<>("No se encontraron inmuebles con el id : " + id, HttpStatus.OK);
	}

	/**
	 * Metodo para filtrar el listado total de inmuebles a partir de valores
	 * recibidos.
	 * 
	 * @param filtro
	 * @return Retorna una lista de todos los inmuebles que coincidan o una lista
	 *         vacía caso que no haya coincidencias
	 * @author Andres Mariano Fernández
	 */
	@PostMapping("/filtrar")
	public ResponseEntity<?> filtrarInmuebles(@RequestBody FiltroInmueble filtro) {
		List<Inmueble> inmueblesFiltrados = inmuebleService.filtrarInmuebles(filtro);
		if (inmueblesFiltrados.isEmpty())
			log.info("No hay inmuebles con los Valores ingresados");
		return new ResponseEntity<>(inmueblesFiltrados, HttpStatus.OK);
	}

	/**
	 * Metodo para crear o actualizar un inmueble
	 * 
	 * @param inmueble
	 * @return Retorna el inmueble nuevo o el inmueble que fue actualizado en la
	 *         BBDD
	 * @author Andres Mariano Fernández
	 */
	@PostMapping("/guardar")
	public ResponseEntity<Inmueble> guardarInmueble(@RequestBody Inmueble inmueble) {
		return new ResponseEntity<>(inmuebleService.save(inmueble), HttpStatus.OK);
	}

	/**
	 * Metodo para eiminar un inmueble especificando su id
	 * 
	 * @param id
	 * @return Retorna un valor true si el inmueble fue eliminado satisfactoriamente
	 *         o informacion caso de error.
	 * @author Andres Mariano Fernández
	 */
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarInmueble(@PathVariable String id) {
		boolean eliminado = inmuebleService.delete(id);
		if (eliminado)
			return new ResponseEntity<>(eliminado, HttpStatus.OK);
		return new ResponseEntity<>("El inmueble con id: " + id + " no existe o no se ha podido eliminar.",
				HttpStatus.OK);
	}

}

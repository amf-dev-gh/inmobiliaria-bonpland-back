package com.andres.inmobiliariaBonpland;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.andres.inmobiliariaBonpland.model.Inmueble;
import com.andres.inmobiliariaBonpland.model.dto.RegistroUsuarioDto;
import com.andres.inmobiliariaBonpland.service.InmuebleService;
import com.andres.inmobiliariaBonpland.service.implement.AuthenticationService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class InmobiliariaBonplandApplication {

	public static void main(String[] args) {
		SpringApplication.run(InmobiliariaBonplandApplication.class, args);
	}

	// Inserta inmuebles al iniciar la API
	@Bean
	@Transactional
	CommandLineRunner initData(InmuebleService inmuebleService, AuthenticationService authService) {
		return args -> {
			//Crear inmuebles para que la lista no este vacía
			List<Inmueble> inmuebles = new ArrayList<>();
			inmuebles.add(new Inmueble("Argentina", "Cordoba", "Las Palmas", 150, 4, "Alquiler", 900, "Disponible",
					"/assets/foto1.jpeg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("España", "Madrid", "Puerta del mar", 100, 3, "Venta", 95000, "Reservado",
					"/assets/foto2.jpeg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("Argentina", "Cordoba", "Poeta Lugones", 200, 4, "Venta", 190000, "Disponible",
					"/assets/foto3.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("España", "Galicia", "Pontevedra", 80, 2, "Venta", 110000, "Vendido",
					"/assets/foto4.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("Argentina", "Cordoba", "Cerro de las Rosas", 190, 5, "Venta", 210000,
					"Disponible", "/assets/foto5.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("España", "Valencia", "Manises", 120, 4, "Alquiler", 750, "Alquilado",
					"/assets/foto6.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("Argentina", "Cordoba", "Las Palmas", 150, 3, "Venta", 155000, "Disponible",
					"/assets/foto7.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("España", "Malaga", "Malagueta", 60, 1, "Alquiler", 500, "Alquilado",
					"/assets/foto8.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("Argentina", "Buenos Aires", "Palermo", 85, 2, "Alquiler", 590, "Disponible",
					"/assets/foto9.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("Argentina", "Cordoba", "Yapeyu", 130, 4, "Alquiler", 120000, "Reservado",
					"/assets/foto10.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("España", "Cordoba", "El arenal", 100, 3, "Venta", 110000, "Reservado",
					"/assets/foto11.jpg", "Departamento espacioso a estrenar"));
			inmuebles.add(new Inmueble("España", "Valencia", "Benimaclet", 175, 5, "Alquiler", 950, "Alquilado",
					"/assets/foto12.jpeg", "Departamento espacioso a estrenar"));

			for (Inmueble i : inmuebles) {
				inmuebleService.save(i);
			}
			//Crea el usuario Admin
			authService.registrar(new RegistroUsuarioDto("admin","12345","Administrador","admin@mail.com","ADMIN"));
		};
	}

}

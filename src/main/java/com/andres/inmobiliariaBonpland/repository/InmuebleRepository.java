package com.andres.inmobiliariaBonpland.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.andres.inmobiliariaBonpland.model.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, String> {

	@Query("SELECT i FROM Inmueble i WHERE " + "(:pais IS NULL OR LOWER(i.pais) LIKE LOWER(CONCAT('%', :pais, '%'))) "
			+ "AND (:ciudad IS NULL OR LOWER(i.ciudad) LIKE LOWER(CONCAT('%', :ciudad, '%'))) "
			+ "AND (:barrio IS NULL OR LOWER(i.barrio) LIKE LOWER(CONCAT('%', :barrio, '%'))) "
			+ "AND (:cantidadAmbientesMin IS NULL OR :cantidadAmbientesMax IS NULL OR i.cantAmbientes BETWEEN :cantidadAmbientesMin AND :cantidadAmbientesMax) "
			+ "AND (:costoMinimo IS NULL OR :costoMaximo IS NULL OR i.costo BETWEEN :costoMinimo AND :costoMaximo) "
			+ "AND (:metrosMinimos IS NULL OR :metrosMaximos IS NULL OR i.metrosCuadrados BETWEEN :metrosMinimos AND :metrosMaximos) "
			+ "AND (:tipoDeContratacion IS NULL OR LOWER(i.tipoDeContratacion) = LOWER(:tipoDeContratacion))")
	List<Inmueble> filtrarInmuebles(@Param("pais") String pais, @Param("ciudad") String ciudad,
			@Param("barrio") String barrio, @Param("cantidadAmbientesMin") Integer cantidadAmbientesMin,
			@Param("cantidadAmbientesMax") Integer cantidadAmbientesMax, @Param("costoMinimo") Integer costoMinimo,
			@Param("costoMaximo") Integer costoMaximo, @Param("metrosMinimos") Integer metrosMinimos,
			@Param("metrosMaximos") Integer metrosMaximos, @Param("tipoDeContratacion") String tipoDeContratacion);

}

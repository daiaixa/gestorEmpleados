package com.crud.gestorEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.gestorEmpleados.model.LicenciaConducir;

@Repository
public interface ILicenciaConducirRepository extends JpaRepository<LicenciaConducir, Long> {

		//QH: Comprueba si un recurso existe por medio de se patente
		boolean existsByNroLicencia(Long nro);
		//QH: Comprueba que el numero de patente no se encuentre registrado con otro id
		boolean existsByNroLicenciaAndIdIsNot(Long nroLicencia, Long id);
		
}

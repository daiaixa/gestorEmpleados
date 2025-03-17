package com.crud.gestorEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.gestorEmpleados.model.Vehiculo;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

	//QH: Comprueba si un recurso existe por medio de se patente
	boolean existsByPatente(String patente);
	//QH: Comprueba que el numero de patente no se encuentre registrado con otro id
	boolean existsByPatenteAndIdIsNot(String patente, Long id);
	
}

package com.crud.gestorEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.gestorEmpleados.model.EmpleadoManejaVehiculo;

@Repository
public interface IEmpleadoManejaVehiculoRepository extends JpaRepository<EmpleadoManejaVehiculo, Long>{

}

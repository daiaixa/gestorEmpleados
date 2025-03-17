package com.crud.gestorEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.gestorEmpleados.model.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{

}

package com.crud.gestorEmpleados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.gestorEmpleados.exception.InexistenteException;
import com.crud.gestorEmpleados.model.EmpleadoManejaVehiculo;
import com.crud.gestorEmpleados.repository.IEmpleadoManejaVehiculoRepository;

@Service
public class EmpleadoManejaVehiculoService implements ICRUDService<EmpleadoManejaVehiculo> {

	private final IEmpleadoManejaVehiculoRepository repoEmpleadoVehiculo;

	public EmpleadoManejaVehiculoService(IEmpleadoManejaVehiculoRepository repoEmpleadoVehiculo) {
		this.repoEmpleadoVehiculo = repoEmpleadoVehiculo;
	}

	
	
	// METODOS
	@Override
	public void crearElemento(EmpleadoManejaVehiculo elemento) {
		repoEmpleadoVehiculo.save(elemento);
	}

	
	
	@Override
	public void modificarElemento(EmpleadoManejaVehiculo elemento, Long id) {
		// TODO controlar y completar
	}

	
	
	@Override
	public void eliminarElemento(Long id) {
		if (!repoEmpleadoVehiculo.existsById(id)) {
			throw new InexistenteException("No existe el recurso que está buscando.");
		}

	}

	
	
	@Override
	public EmpleadoManejaVehiculo buscarElemento(Long id) {
		EmpleadoManejaVehiculo empleadoVehiculo = repoEmpleadoVehiculo.findById(id)
				.orElseThrow(() -> new InexistenteException("No existe el recurso que está buscando."));
	
		return empleadoVehiculo;
	}

	
	
	@Override
	public List<EmpleadoManejaVehiculo> listarElementos() {
		return repoEmpleadoVehiculo.findAll();
	}

}

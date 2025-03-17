package com.crud.gestorEmpleados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.gestorEmpleados.exception.InexistenteException;
import com.crud.gestorEmpleados.exception.RequestException;
import com.crud.gestorEmpleados.model.Vehiculo;
import com.crud.gestorEmpleados.repository.IVehiculoRepository;

@Service
public class VehiculoService implements ICRUDService<Vehiculo> {

	
	//inyectamos el repositorio via constructor
	private final IVehiculoRepository repoVehiculo;
	
	public VehiculoService(IVehiculoRepository repoVehiculo) {
		this.repoVehiculo = repoVehiculo;
	}

	
		
	//METODOS
	@Override
	public void crearElemento(Vehiculo vehiculo) {
		if (repoVehiculo.existsByPatente(vehiculo.getPatente())) {
			throw new RequestException(String.format("El número de patente %s, ya se encuentra registrado.",
					vehiculo.getPatente()));
		}
		repoVehiculo.save(vehiculo);	
	}

	
	@Override
	public void modificarElemento(Vehiculo vehiculoActualizado, Long id) {
		Vehiculo vehiculoAnterior = repoVehiculo.findById(id).orElseThrow(() -> new InexistenteException(String.
				format("El recurso con id: %d, no se encuentra registrado.", id)));
		
		
		if (repoVehiculo.existsByPatenteAndIdIsNot(vehiculoActualizado.getPatente(), id)) {
			throw new RequestException(String.format("El número de patente %s, ya se encuentra registrado.",
					vehiculoActualizado.getPatente()));
			}
		
		vehiculoAnterior.setEstado(vehiculoActualizado.getEstado());
		vehiculoAnterior.setMarca(vehiculoActualizado.getMarca());
		vehiculoAnterior.setModelo(vehiculoActualizado.getModelo());
		vehiculoAnterior.setPatente(vehiculoActualizado.getPatente());
		
		repoVehiculo.save(vehiculoAnterior);
	}
		
	
	
	@Override
	public void eliminarElemento(Long id) {
		if (!repoVehiculo.existsById(id)) {
			throw new InexistenteException(String.
				format("El vehiculo con id: %d que desea eliminar, no se encuentra registrado.", id));
		}
		repoVehiculo.deleteById(id);		
	}

	
	@Override
	public Vehiculo buscarElemento(Long id) {
		
		Vehiculo vehiculo = repoVehiculo.findById(id).orElseThrow(() -> new InexistenteException(String.
				format("El vehiculo con id: %d, no se encuentra registrado.", id)));
				
		return vehiculo;
	}

	
	@Override
	public List<Vehiculo> listarElementos() {
		return repoVehiculo.findAll();
	}
	
	
	//TODO los metodos que manipulen la lista compuesta por los empleados que manejan los vehiculs
}

package com.crud.gestorEmpleados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.gestorEmpleados.exception.InexistenteException;
import com.crud.gestorEmpleados.exception.RequestException;
import com.crud.gestorEmpleados.model.Empleado;
import com.crud.gestorEmpleados.model.LicenciaConducir;
import com.crud.gestorEmpleados.repository.IEmpleadoRepository;
import com.crud.gestorEmpleados.repository.ILicenciaConducirRepository;

@Service
public class LicenciaConducirService implements ICRUDService<LicenciaConducir> {

	private final ILicenciaConducirRepository repoLicencia;
	private final IEmpleadoRepository repoEmpleado;
	
	
	public LicenciaConducirService(ILicenciaConducirRepository repoLicencia,
			IEmpleadoRepository repoEmpleado) {
		this.repoEmpleado = repoEmpleado;
		this.repoLicencia = repoLicencia;
	}

	

	//METODOS
	@Override
	public void crearElemento(LicenciaConducir nuevaLicencia) {
		if (repoLicencia.existsByNroLicencia(nuevaLicencia.getNroLicencia())) {
			throw new RequestException("El número de licencia ya se encuentra registrado.");
		}
		repoLicencia.save(nuevaLicencia);
	}
	

	@Override
	public void modificarElemento(LicenciaConducir nuevaLicencia, Long id) {
		
		 LicenciaConducir licenciaAnterior = repoLicencia.findById(id).orElseThrow(() -> 
		 new InexistenteException(String.
					format("La licencia con el id: %d que desea modificar, no existe.", id)));
		 
		 if (repoLicencia.existsByNroLicenciaAndIdIsNot(nuevaLicencia.getNroLicencia(), licenciaAnterior.getId())) {
				throw new RequestException("El número de licencia ya se encuentra registrado.");
			}
		 
		 licenciaAnterior.setClase(nuevaLicencia.getClase());
		 licenciaAnterior.setNroLicencia(nuevaLicencia.getNroLicencia());
		 licenciaAnterior.setObservaciones(nuevaLicencia.getObservaciones());
		 licenciaAnterior.setVencimiento(nuevaLicencia.getVencimiento());
		 
		 Empleado empleado = repoEmpleado.findById(id).orElseThrow(()->new InexistenteException(String.
					format("El empleado con el id: %d, no existe.", id)));
		 
		 licenciaAnterior.setEmpleado(empleado);
		 
		 repoLicencia.save(licenciaAnterior);
				 
	}

	@Override
	public void eliminarElemento(Long id) {
		if (!repoLicencia.existsById(id)) {
			throw new InexistenteException(String.
					format("La licencia con el id: %d que desea eliminar, no existe.", id));
		}
		repoLicencia.deleteById(id);
		
	}

	@Override
	public LicenciaConducir buscarElemento(Long id) {
		LicenciaConducir licencia = repoLicencia.findById(id).orElseThrow(()-> new InexistenteException(String.
				format("La licencia con el id: %d que desea buscar, no existe.", id)));
		return licencia;
	}

	@Override
	public List<LicenciaConducir> listarElementos() {
		return repoLicencia.findAll();
	}
	
	
	
	
}

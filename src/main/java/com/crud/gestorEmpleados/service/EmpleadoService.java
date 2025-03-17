package com.crud.gestorEmpleados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.gestorEmpleados.exception.InexistenteException;
import com.crud.gestorEmpleados.model.DocumentoIdentidad;
import com.crud.gestorEmpleados.model.Empleado;
import com.crud.gestorEmpleados.repository.IDocumentoIdentidadRepository;
import com.crud.gestorEmpleados.repository.IEmpleadoRepository;

@Service
public class EmpleadoService implements ICRUDService<Empleado> {

	private final IEmpleadoRepository repoEmpleado;
	private final IDocumentoIdentidadRepository repoDocumento;

	public EmpleadoService(IEmpleadoRepository repoEmpleado, IDocumentoIdentidadRepository repoDocumento) {
		this.repoEmpleado = repoEmpleado;
		this.repoDocumento = repoDocumento;
	}

	// METODOS
	@Override
	public void crearElemento(Empleado empleado) {
		repoEmpleado.save(empleado);
	}

	@Override
	public void modificarElemento(Empleado empleadoActualiz, Long id) {

		Empleado empleadoViejo = repoEmpleado.findById(id).orElseThrow(() -> new InexistenteException(
				String.format("El empleado con el id: %d, no se encuentra registrado", id)));

		empleadoViejo.setNombre(empleadoActualiz.getNombre());
		empleadoViejo.setApellido(empleadoActualiz.getApellido());
		empleadoViejo.setDomicilio(empleadoActualiz.getDomicilio());
		empleadoViejo.setEsChofer(empleadoActualiz.isEsChofer());
		empleadoViejo.setNumeroTel(empleadoActualiz.getNumeroTel());

		if (empleadoActualiz.getDocIdentidad().getId() != null
				&& !empleadoActualiz.getDocIdentidad().equals(empleadoViejo.getDocIdentidad())) {
			DocumentoIdentidad docActualizado = repoDocumento.findById(empleadoActualiz.getDocIdentidad().getId())
					.orElseThrow(() -> new InexistenteException(
							String.format("El documento con el id: %d que se desea actualizar, no existe", id)));
			empleadoViejo.setDocIdentidad(docActualizado);
		}

		repoEmpleado.save(empleadoViejo);
	}

	@Override
	public void eliminarElemento(Long id) {
		if (!repoEmpleado.existsById(id)) {
			throw new InexistenteException(String.format("El empleado con el id: %d, no se encuentra registrado", id));
		}
		repoEmpleado.deleteById(id);
	}

	@Override
	public Empleado buscarElemento(Long id) {

		Empleado empleado = repoEmpleado.findById(id).orElseThrow(() -> new InexistenteException(
				String.format("El empleado con el id: %d, no se encuentra registrado", id)));

		return empleado;
	}

	@Override
	public List<Empleado> listarElementos() {
		return repoEmpleado.findAll();
	}

	
	//TODO los metodos que manipule la lista de los vehiculos que manejo, junto con los demas datos.
}

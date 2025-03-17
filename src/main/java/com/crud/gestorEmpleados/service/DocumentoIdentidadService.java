package com.crud.gestorEmpleados.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.crud.gestorEmpleados.exception.InexistenteException;
import com.crud.gestorEmpleados.exception.RequestException;
import com.crud.gestorEmpleados.model.DocumentoIdentidad;
import com.crud.gestorEmpleados.repository.IDocumentoIdentidadRepository;

@Service
public class DocumentoIdentidadService implements ICRUDService<DocumentoIdentidad> {

	
// Voy a probar inyectar el repositorio por medio de un constructor, siendo la mejor practica
	private final IDocumentoIdentidadRepository docuRepository;
	
	public DocumentoIdentidadService( IDocumentoIdentidadRepository docuRepository) {
		this.docuRepository = docuRepository;
	}
	
	
	//METODOS
	@Override
	public void crearElemento(DocumentoIdentidad docu) {
		
		if (docuRepository.existsByTipoDocumentoAndNroDocumento(docu.getTipoDocumento(),docu.getNroDocumento())) {
			throw new RequestException("El tipo y número de documento ya existen.");
		}
			docuRepository.save(docu);	
	}

	
	@Override
	public void modificarElemento(DocumentoIdentidad docuNuevo, Long id) {
	
		DocumentoIdentidad docAnterior = docuRepository.findById(id).orElseThrow(()-> 
			new InexistenteException(String.format("No se encontro el Documento con el id: %d que desea modificar", id)));
		
		//Validamos que no se repitan los campos con otro recurso de la tabla
		if (docuRepository.existsByTipoDocumentoAndNroDocumentoAndIdIsNot(docuNuevo.getTipoDocumento(),
				docuNuevo.getNroDocumento(), docAnterior.getId())) {
			throw new RequestException("El tipo y número de documento pertenece a otro registro.");
		}
		
		//si lo encontro y no hubo errores, se procede a modificar y guardar
		docAnterior.setTipoDocumento(docuNuevo.getTipoDocumento());
		docAnterior.setNroDocumento(docuNuevo.getNroDocumento());
		
		docuRepository.save(docAnterior);	
	}
	

	@Override
	public void eliminarElemento(Long id) {
		if (!docuRepository.existsById(id)) {
			new InexistenteException(String.format("No se encontro el Documento con el id: %d que desea eliminar", id));
		}
		docuRepository.deleteById(id);
	}

	
	@Override
	public DocumentoIdentidad buscarElemento(Long id) {
		DocumentoIdentidad documento = docuRepository.findById(id).orElseThrow(()-> 
			new InexistenteException(String.format("No se encontro el Documento con el id: %d ", id)));
		
		return documento;
	}

	
	@Override
	public List<DocumentoIdentidad> listarElementos() {
		
		return docuRepository.findAll();
	}

	
}

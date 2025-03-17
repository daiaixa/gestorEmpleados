package com.crud.gestorEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.gestorEmpleados.enums.TipoDocumento;
import com.crud.gestorEmpleados.model.DocumentoIdentidad;

//Se recomienda marcar la anotacion para una mejor captura de excepciones de JPA
@Repository
public interface IDocumentoIdentidadRepository extends JpaRepository<DocumentoIdentidad, Long> {

	//QH: Comprueba que no exista un recurso con los mismos campos
	public boolean existsByTipoDocumentoAndNroDocumento(TipoDocumento tipoDoc, Long nroDoc);
	
	//QH: Comprueba que no exista un recurso con los mismos valores de atributos pero que no compratan el id
	public boolean existsByTipoDocumentoAndNroDocumentoAndIdIsNot(TipoDocumento tipoDoc, Long nroDoc, Long id);
	
	
	
	
	
}
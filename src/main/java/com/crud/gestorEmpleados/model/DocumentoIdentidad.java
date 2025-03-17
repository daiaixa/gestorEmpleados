package com.crud.gestorEmpleados.model;

import com.crud.gestorEmpleados.enums.TipoDocumento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "documentoIdentidad",
uniqueConstraints = @UniqueConstraint(columnNames = {"tipoDocumento", "nroDocumento"})) 
//Se especifica que sean atributos unicos
public class DocumentoIdentidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoDocumento tipoDocumento;
	@NotNull
	private Long nroDocumento;
	
	
	//CONSTRUCTOR
	public DocumentoIdentidad() {}

	
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}


	public Long getNroDocumento() {
		return nroDocumento;
	}


	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public void setNroDocumento(Long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	//METODOS
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoIdentidad) {
			DocumentoIdentidad docu = (DocumentoIdentidad) obj;
			
			return docu.getTipoDocumento() == tipoDocumento && docu.getNroDocumento() == nroDocumento;
		}
		return super.equals(obj);
	}
	
	
	
	
}

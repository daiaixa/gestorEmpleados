package com.crud.gestorEmpleados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(max = 15)
	private String nombre;
	@NotNull
	@Size(max = 15)
	private String apellido;
	
	@OneToOne
	@JoinColumn(name =  "idDocumento", nullable = false)
	private DocumentoIdentidad docIdentidad;
	@NotNull
	private boolean esChofer;
	@NotNull
	@Size(max = 50)
	private String domicilio;
	@NotNull
	@Size(max = 25)
	private String numeroTel;
	
	
	//CONSTRUCTOR
	public Empleado() {}


	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public DocumentoIdentidad getDocIdentidad() {
		return docIdentidad;
	}


	public boolean isEsChofer() {
		return esChofer;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public String getNumeroTel() {
		return numeroTel;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setDocIdentidad(DocumentoIdentidad docIdentidad) {
		this.docIdentidad = docIdentidad;
	}


	public void setEsChofer(boolean esChofer) {
		this.esChofer = esChofer;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}



	//METODOS
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Empleado) {
			Empleado empleado = (Empleado) obj;
			
			return empleado.getDocIdentidad().equals(docIdentidad);
		}
		return super.equals(obj);
	}
	
	
	

}

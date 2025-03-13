package com.crud.gestorEmpleados.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "LicenciasDeConducir")
public class LicenciaConducir {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private Long nroLicencia;
	@NotBlank
	private String clase; //TODO en una proxima version, podria agregar una relacion con una tabla Clases..
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/aaaa")
	private LocalDate vencimiento;
	@Size(max = 500)
	private String observaciones;
	@OneToOne
	@JoinColumn(name = "idEmpleado", nullable = false)
	private Empleado Empleado; //FK
	
	
	
	//CONSTRUCTOR
	public LicenciaConducir() {}

	
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	
	public Long getNroLicencia() {
		return nroLicencia;
	}

	
	public String getClase() {
		return clase;
	}

	
	public LocalDate getVencimiento() {
		return vencimiento;
	}

	
	public String getObservaciones() {
		return observaciones;
	}

	
	public Empleado getEmpleado() {
		return Empleado;
	}

	
	public void setNroLicencia(Long nroLicencia) {
		this.nroLicencia = nroLicencia;
	}

	
	public void setClase(String clase) {
		this.clase = clase;
	}

	
	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
	public void setEmpleado(Empleado empleado) {
		Empleado = empleado;
	}
	
	
	//METODOS
	
	
	
	
	
	
}

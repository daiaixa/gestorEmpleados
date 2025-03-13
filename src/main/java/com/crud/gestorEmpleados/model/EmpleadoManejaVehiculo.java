package com.crud.gestorEmpleados.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmpleadoManejaVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "idEmpleado")
	private Empleado chofer;
	@OneToMany
	@JoinColumn(name = "idVehiculo")
	private Vehiculo vehiculo;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/aaaa")
	private LocalDate fechaDesde;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/aaaa")
	private LocalDate fechaHasta;
	@NotNull
	@Size(max = 500)
	private String detalle; //ACA, LAS EMPRESAN USAN UN CHECK IN QUE COMPLETAN PARA CONOCER EL ESTADO EN QUE LA RECIBE Y EN QUE LA ENTREGA
	
	
	//CONSTRUCTOR
	private EmpleadoManejaVehiculo() {}


	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}


	public Empleado getChofer() {
		return chofer;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public LocalDate getFechaDesde() {
		return fechaDesde;
	}


	public LocalDate getFechaHasta() {
		return fechaHasta;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setChofer(Empleado chofer) {
		this.chofer = chofer;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	

	
	
	
	
}

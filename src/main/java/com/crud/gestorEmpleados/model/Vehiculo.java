package com.crud.gestorEmpleados.model;

import com.crud.gestorEmpleados.enums.EstadoVehiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(max = 15)
	private String marca;
	@NotNull
	@Size(max = 15)
	private int modelo;
	@NotNull
	@Size(max = 15)
	private String patente;
	@NotNull
	@Enumerated(EnumType.STRING)
	private EstadoVehiculo estado;
	
	
	//CONSTRUCTOR
	public Vehiculo() {}


	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}


	public String getMarca() {
		return marca;
	}


	public int getModelo() {
		return modelo;
	}


	public String getPatente() {
		return patente;
	}


	public EstadoVehiculo getEstado() {
		return estado;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public void setModelo(int modelo) {
		this.modelo = modelo;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}


	public void setEstado(EstadoVehiculo estado) {
		this.estado = estado;
	}
	
	
	

}

package com.crud.gestorEmpleados.DTO;

import org.springframework.http.HttpStatus;

public class ErrorDTO {

	private String mensaje;
	private HttpStatus httpStatus;
	
	//CONSTRUCTOR
	public ErrorDTO(String msj, HttpStatus httpStatus) {
		this.mensaje = msj;
		this.httpStatus = httpStatus;
	}
	
	
	
	//GETTERS Y SETTERS
	public void setMensaje(String msj) {
		this.mensaje = msj;
	}
	
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	public String getMensaje() {
		return mensaje;
	}
	
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}

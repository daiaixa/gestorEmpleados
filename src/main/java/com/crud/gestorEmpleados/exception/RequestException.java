package com.crud.gestorEmpleados.exception;

public class RequestException extends RuntimeException {

		
	
	public RequestException(String msj) {
		super(msj);
	}
	
	//Podria tener otros atributos, pero no se me están ocurriendo
}

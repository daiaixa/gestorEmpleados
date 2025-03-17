package com.crud.gestorEmpleados.exception;

public class InexistenteException extends RuntimeException {
	//¿Porque? porque de esa forma no me obluga a capturarla con un try chatch

	
	//CONSTRUCTOR
	public InexistenteException(String msj) {
		super(msj);
	}
	
}

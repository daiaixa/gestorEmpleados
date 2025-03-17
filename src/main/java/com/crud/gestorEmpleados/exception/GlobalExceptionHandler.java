package com.crud.gestorEmpleados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.gestorEmpleados.DTO.ErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	//QH: Captura las excepciones lanzadas por algun error de llenado en los campos del recurso o bien, 
	// hay campos unicos repetidos
	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity<ErrorDTO> requestExceptionHandler (RuntimeException e) {
		
		ErrorDTO error = new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(error, error.getHttpStatus());
		
	}
	
	
	//QH: Captura las excepciones lanzadas que surgen cuando un recurso no es encontrado dentro de la BD
	@ExceptionHandler(value = InexistenteException.class)
	public ResponseEntity<ErrorDTO> inexistenteExceptionHandler (InexistenteException e) {
		
		ErrorDTO error = new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(error, error.getHttpStatus());
		
	}
	
}

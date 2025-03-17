package com.crud.gestorEmpleados.service;

import java.util.List;

public interface ICRUDService<T> {

	//QH: Crea un recurso
	public void crearElemento(T elemento);
	
	//QH: Modifica un recurso
	public void modificarElemento(T elemento, Long id);
	
	//QH: Elimina un recurso
	public void eliminarElemento(Long id);
	
	//QH: Trae un recurso por medio de su id
	public T buscarElemento(Long id);
	
	//QH: Lista todos los recursos almacenados
	public List<T> listarElementos();
	
}

 package com.ecommerce2.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce2.model.Orden;
import com.ecommerce2.model.Usuario;


public interface IOrdenService {
	
	Orden save(Orden orden);
	List<Orden> findAll();
	String generarNumeroOrden(); 
	List<Orden> findByUsuario(Usuario usuario);
	Optional<Orden>findById(Integer id);
	

} 

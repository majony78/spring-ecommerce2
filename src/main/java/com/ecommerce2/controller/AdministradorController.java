package com.ecommerce2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce2.model.Orden;
import com.ecommerce2.model.Producto;
import com.ecommerce2.service.IOrdenService;
import com.ecommerce2.service.IUsuarioService;
import com.ecommerce2.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AdministradorController.class);

	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IOrdenService ordenService;
	
	
	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		return "administrador/home";
	}
	
	@GetMapping("/usuarios")
	public String usuario(Model model) {
		
		model.addAttribute("usuarios", usuarioService.findAll()); 
		
		return "administrador/usuarios";
	}
	
	@GetMapping("/ordenes")
	public String ordenes(Model model) {
		 model.addAttribute("ordenes", ordenService.findAll());
		return "administrador/ordenes";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable Integer id, Model model) {
		 log.info("Id de la orden: {}", id);
		Orden orden = ordenService.findById(id).get();
		
		model.addAttribute("detalles", orden.getDetalle());
		return"administrador/detalleorden";
	}

}

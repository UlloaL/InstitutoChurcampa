package com.edu.iestpch.app.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.iestpch.app.models.entity.Modulo;
import com.edu.iestpch.app.models.service.IModuloService;

@RestController
@RequestMapping("/modulos")
public class ModulosController {
	
	@Autowired
	private IModuloService moduloService;
	
	@GetMapping(value = "/all")	
	public List<Modulo> getRespuesta() {
		return (List<Modulo>) moduloService.findAll();
		
	}
}

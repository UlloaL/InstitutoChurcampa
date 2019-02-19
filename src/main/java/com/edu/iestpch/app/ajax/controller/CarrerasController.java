package com.edu.iestpch.app.ajax.controller;



import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.edu.iestpch.app.models.service.ICarreraService;
//Controller Ajax......RestController
@RestController
@RequestMapping("/api/carreras")
public class CarrerasController {
	
	@Autowired
	private ICarreraService carreraService;
	//private ArrayList<Carrera> carrerras;
	
	//Acction Ajax que retorna cualquier tipo de arrayList<?>. Esto solo es una version de prueba, aun queda hacer las validaciones 
	//en caso de que no se pueda conectar, .....  
	@GetMapping(value = "/all")	
	public ArrayList<?> getResource() {
		return (ArrayList<?>) carreraService.findAll();
		
	}
}

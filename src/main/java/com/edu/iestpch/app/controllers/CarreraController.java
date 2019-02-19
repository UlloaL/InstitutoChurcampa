package com.edu.iestpch.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.iestpch.app.models.entity.Carrera;
import com.edu.iestpch.app.models.service.ICarreraService;

@Controller
public class CarreraController {
	@Autowired
	private ICarreraService carreraService;
	
	@RequestMapping(value="/listarCar")
	public String listar(Model model) {			
		
		model.addAttribute("Titulo","Listado de Carreras");
		model.addAttribute("carreras", carreraService.findAll());		
		return "listarCar"; //return vista!!!
	}
	@RequestMapping(value="/formCar", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Carrera carrera = new Carrera();
		model.put("carrera", carrera);
		model.put("Titulo", "Registrar Carrera");
		return "formCar";
	}
	@RequestMapping(value="/formCar", method=RequestMethod.POST)
	public String guardar(Carrera carrera, RedirectAttributes flash) {
		String mensajeflash = (carrera.getId()!=0)? "Carrera Actualizado con exito" : "Carrera Creado con Exito";
		carreraService.save(carrera);		
		flash.addFlashAttribute("success", mensajeflash);
		return "redirect:/listarCar";
	}
	@RequestMapping(value="/formCar/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Carrera carrera=null;
		if(id>0) {
			carrera= carreraService.findOne(id);
			if(carrera==null) {
				flash.addFlashAttribute("error", "Carrera no existe en la BD");
				return "redirect:/listarCar";
			}
		}else {
			flash.addFlashAttribute("error", "Id no puede ser cero");
			return "redirect:/listarCar";
		}
		model.put("carrera", carrera);
		model.put("Titulo", "Editar Carrera");
		return "formCar";
	}
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if(id>0) {
			carreraService.delete(id);
			flash.addFlashAttribute("success", "Carrera Eliminado con exito");
		}
		return "redirect:/listarCar";
	}

}

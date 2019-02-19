package com.edu.iestpch.app.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.iestpch.app.models.entity.*;
import com.edu.iestpch.app.models.service.IEstudianteService;


@Controller
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
		
	@RequestMapping(value="/listarEst")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		//Pageable pageRequest = PageRequest.of(page, 5);
		
		List<Estudiante> estudiantes = estudianteService.findAll();
		//PageRender<Estudiante> pageRender = new PageRender<>("/listarEst", estudiantes);
		model.addAttribute("Titulo","Listado de Estudiantes");
		model.addAttribute("estudiantes", estudiantes);
		//model.addAttribute("page", pageRender);
		return "listarEst";
	}
	@RequestMapping(value="/formEst", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {				
		Estudiante estudiante = new Estudiante();	
		model.put("estudiante", estudiante);
		model.put("Titulo", "Registrar Estudiante");		
		return "formEst";
	}
	
	@RequestMapping(value="/formEst", method=RequestMethod.POST)
	public String guardar(Estudiante estudiante, RedirectAttributes flash) {
		String mensajeflash = (estudiante.getId()!=0)? "Estudiante Actualizado con exito!":"Estudiante Creado con Exito!";
		estudianteService.save(estudiante);		
		flash.addFlashAttribute("success", mensajeflash);
		return "redirect:/listarEst";
	}
	@RequestMapping(value="/formEst/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Estudiante estudiante=null;
		if(id>0) {
			estudiante= estudianteService.findOne(id);
			if(estudiante==null) {
				flash.addFlashAttribute("error", "Estudiante no existe en la BD");
				return "redirect:/listarEst";
			}
		}else {
			flash.addFlashAttribute("error", "Id no puede ser cero");
			return "redirect:/listarEst";
		}
		model.put("estudiante", estudiante);
		model.put("Titulo", "Editar Estudiante");
		return "formEst";
	}
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if(id>0) {
			estudianteService.delete(id);
			flash.addFlashAttribute("success", "Estudiante Eliminado con exito");
		}
		return "redirect:/listarEst";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model) {		
		model.addAttribute("Titulo", "Pagina Principal");
		return "home";
	}
	
}

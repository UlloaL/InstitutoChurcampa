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

import com.edu.iestpch.app.models.entity.Docente;
import com.edu.iestpch.app.models.service.IDocenteService;

@Controller
public class DocenteController {
	
	@Autowired
	private IDocenteService docenteService;
	
	@RequestMapping(value="/listarDocente")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		//Pageable pageRequest = PageRequest.of(page, 5);
		
		List<Docente> docentes = docenteService.findAll();
		//PageRender<Estudiante> pageRender = new PageRender<>("/listarEst", estudiantes);
		model.addAttribute("Titulo","Listado de Docentes");
		model.addAttribute("docentes", docentes);
		//model.addAttribute("page", pageRender);
		return "listarDocente";
	}
	@RequestMapping(value="/formDocente", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {				
		Docente docente = new Docente();	
		model.put("docente", docente);
		model.put("Titulo", "Registrar Docente");		
		return "formDocente";
	}
	
	@RequestMapping(value="/formDocente", method=RequestMethod.POST)
	public String guardar(Docente docente, RedirectAttributes flash) {
		String mensajeflash = (docente.getId()!=0)? "Docente Actualizado con exito!":"Docente Creado con Exito!";
		docenteService.save(docente);		
		flash.addFlashAttribute("success", mensajeflash);
		return "redirect:/listarDocente";
	}
	@RequestMapping(value="/formDocente/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Docente docente=null;
		if(id>0) {
			docente= docenteService.findOne(id);
			if(docente==null) {
				flash.addFlashAttribute("error", "Docente no existe en la BD");
				return "redirect:/listarDocente";
			}
		}else {
			flash.addFlashAttribute("error", "Id no puede ser cero");
			return "redirect:/listarDocente";
		}
		model.put("docente", docente);
		model.put("Titulo", "Editar Docente");
		return "formDocente";
	}
	@RequestMapping(value="/eliminarDoc/{id}")
	public String eliminarDoc(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if(id>0) {
			docenteService.delete(id);
			flash.addFlashAttribute("success", "El docente a sido eliminado con exito");
		}
		return "redirect:/listarDocente";
	}

}

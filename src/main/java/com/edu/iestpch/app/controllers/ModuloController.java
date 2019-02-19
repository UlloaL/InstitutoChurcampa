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


import com.edu.iestpch.app.models.entity.Modulo;
import com.edu.iestpch.app.models.service.IModuloService;


@Controller
public class ModuloController {

	@Autowired
	private IModuloService moduloService;
		
	@RequestMapping(value="/listarMod")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		//Pageable pageRequest = PageRequest.of(page, 5);
		List<Modulo> modulos = moduloService.findAll();
		//Page<Modulo> modulos = moduloService.findAll(pageRequest);
		//PageRender<Modulo> pageRender = new PageRender<>("/listarMod", modulos);
		model.addAttribute("Titulo","Listado de Modulos Educativos");
		model.addAttribute("modulos", modulos);
		//model.addAttribute("page", pageRender);
		return "listarMod";
	}
	@RequestMapping(value="/formMod", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {				
		Modulo modulo = new Modulo();	
		model.put("modulo", modulo);
		model.put("Titulo", "Registrar Modulo");		
		return "formMod";
	}
	
	@RequestMapping(value="/formMod", method=RequestMethod.POST)
	public String guardar(Modulo modulo, RedirectAttributes flash) {
		String mensajeflash = (modulo.getId()!=0)? "Modulo Actualizado con exito!":"Modulo Creado con Exito!";
		moduloService.save(modulo);		
		flash.addFlashAttribute("success", mensajeflash);
		return "redirect:/listarMod";
	}
	@RequestMapping(value="/formMod/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Modulo modulo=null;
		if(id>0) {
			modulo= moduloService.findOne(id);
			if(modulo==null) {
				flash.addFlashAttribute("error", "Modulo no existe en la BD");
				return "redirect:/listarMod";
			}
		}else {
			flash.addFlashAttribute("error", "Id no puede ser cero");
			return "redirect:/listarMod";
		}
		model.put("modulo", modulo);
		model.put("Titulo", "Editar Modulo Educativo");
		return "formMod";
	}
	@RequestMapping(value="/eliminarMod/{id}")
	public String eliminarMod(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if(id>0) {
			moduloService.delete(id);
			flash.addFlashAttribute("success", "Modulo Educativo Eliminado con exito");
		}
		return "redirect:/listarMod";
	}	
	
}

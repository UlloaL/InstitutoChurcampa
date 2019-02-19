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

import com.edu.iestpch.app.models.entity.UnidadDidactica;
import com.edu.iestpch.app.models.service.IUnidadDidacticaService;

@Controller
public class UnidadDidacticaController {
	
	@Autowired
	private IUnidadDidacticaService unidadDidacticaService;
	
	@RequestMapping(value="/listarUnidadDidactica")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		//Pageable pageRequest = PageRequest.of(page, 5);
		List<UnidadDidactica> unidades = unidadDidacticaService.findAll();
		//Page<Modulo> modulos = moduloService.findAll(pageRequest);
		//PageRender<Modulo> pageRender = new PageRender<>("/listarMod", modulos);
		model.addAttribute("Titulo","Listado de Unidad Didactica");
		model.addAttribute("unidades", unidades);
		//model.addAttribute("page", pageRender);
		return "listarUnidadDidactica";
	}
	@RequestMapping(value="/formUnidadDidactica", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {				
		UnidadDidactica unidad = new UnidadDidactica();	
		model.put("unidad", unidad);
		model.put("Titulo", "Registrar Unidad Didactica");		
		return "formUnidadDidactica";
	}
	
	@RequestMapping(value="/formUnidadDidactica", method=RequestMethod.POST)
	public String guardar(UnidadDidactica unidad, RedirectAttributes flash) {
		String mensajeflash = (unidad.getId()!=0)? "Unidad Didactica Actualizado con exito!":"Unidad Didactica Creado con Exito!";
		unidadDidacticaService.save(unidad);		
		flash.addFlashAttribute("success", mensajeflash);
		return "redirect:/listarUnidadDidactica";
	}
	@RequestMapping(value="/formUnidadDidactica/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		UnidadDidactica unidad=null;
		if(id>0) {
			unidad= unidadDidacticaService.findOne(id);
			if(unidad==null) {
				flash.addFlashAttribute("error", "La Unidad Didactica no existe en la BD");
				return "redirect:/listarUnidadDidactica";
			}
		}else {
			flash.addFlashAttribute("error", "Id no puede ser cero");
			return "redirect:/listarUnidadDidactica";
		}
		model.put("unidad", unidad);
		model.put("Titulo", "Editar Unidad Didactica");
		return "formUnidadDidactica";
	}
	@RequestMapping(value="/eliminarUD/{id}")
	public String eliminarUD(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if(id>0) {
			unidadDidacticaService.delete(id);
			flash.addFlashAttribute("success", "Unidad Didáctica Eliminado con éxito");
		}
		return "redirect:/listarUnidadDidactica";
	}

}

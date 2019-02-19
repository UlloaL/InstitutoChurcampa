package com.edu.iestpch.app.models.service;

import java.util.List;

import com.edu.iestpch.app.models.entity.Docente;

public interface IDocenteService {
	
	public List<Docente> findAll();
	
	public void save(Docente docente);
	
	public Docente findOne(Long id);
	
	public void delete(Long id);

}

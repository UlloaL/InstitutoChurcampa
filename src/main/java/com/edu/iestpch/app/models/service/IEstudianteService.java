package com.edu.iestpch.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.iestpch.app.models.entity.Estudiante;

public interface IEstudianteService {
	
	public List<Estudiante> findAll();
	
	public Page<Estudiante> findAll(Pageable pageable);
	
	public void save(Estudiante estudiante);
	
	public Estudiante findOne(Long id);
	
	public void delete(Long id);
}

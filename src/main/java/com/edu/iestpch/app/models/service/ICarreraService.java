package com.edu.iestpch.app.models.service;

import java.util.List;

import com.edu.iestpch.app.models.entity.Carrera;

public interface ICarreraService {
	
	public List<Carrera> findAll();		
	
	public void save(Carrera carrera);
	
	public Carrera findOne(Long id);
	
	public void delete(Long id);

}

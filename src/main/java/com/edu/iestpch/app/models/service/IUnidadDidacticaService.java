package com.edu.iestpch.app.models.service;

import java.util.List;

import com.edu.iestpch.app.models.entity.UnidadDidactica;

public interface IUnidadDidacticaService {
	
	public List<UnidadDidactica> findAll();
	
	public void save(UnidadDidactica unidadDidactica);
	
	public UnidadDidactica findOne(Long id);
	
	public void delete(Long id);

}

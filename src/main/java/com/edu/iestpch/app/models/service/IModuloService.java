package com.edu.iestpch.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.iestpch.app.models.entity.Modulo;

public interface IModuloService {
	
	public List<Modulo> findAll();
	
	public Page<Modulo> findAll(Pageable pageable);
	
	public void save(Modulo modulo);
	
	public Modulo findOne(Long id);
	
	public void delete(Long id);

}

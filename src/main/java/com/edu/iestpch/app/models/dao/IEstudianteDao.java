package com.edu.iestpch.app.models.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.iestpch.app.models.entity.*;

public interface IEstudianteDao extends PagingAndSortingRepository<Estudiante, Long> {
	
	}

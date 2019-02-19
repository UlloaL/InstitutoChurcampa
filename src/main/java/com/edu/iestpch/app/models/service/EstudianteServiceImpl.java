package com.edu.iestpch.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.iestpch.app.models.dao.IEstudianteDao;
import com.edu.iestpch.app.models.entity.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteDao estudianteDao;
	@Override
	@Transactional(readOnly=true)
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub
		return (List<Estudiante>) estudianteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) {
		// TODO Auto-generated method stub
		estudianteDao.save(estudiante);
	}

	@Override
	@Transactional(readOnly=true)
	public Estudiante findOne(Long id) {
		// TODO Auto-generated method stub
		return estudianteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		estudianteDao.deleteById(id);
	}

	@Override
	public Page<Estudiante> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return estudianteDao.findAll(pageable);
	}

}

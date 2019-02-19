package com.edu.iestpch.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.iestpch.app.models.dao.ICarreraDao;
import com.edu.iestpch.app.models.entity.Carrera;

@Service
public class CarreraServiceImpl implements ICarreraService{

	@Autowired
	private ICarreraDao carreraDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Carrera> findAll() {
		// TODO Auto-generated method stub
		return (List<Carrera>) carreraDao.findAll();
	}

	@Override
	@Transactional
	public void save(Carrera carrera) {
		// TODO Auto-generated method stub
		carreraDao.save(carrera);
	}

	@Override
	@Transactional(readOnly=true)
	public Carrera findOne(Long id) {
		// TODO Auto-generated method stub
		return carreraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		carreraDao.deleteById(id);
	}
	

}

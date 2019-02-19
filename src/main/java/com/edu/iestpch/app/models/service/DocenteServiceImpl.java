package com.edu.iestpch.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.iestpch.app.models.dao.IDocenteDao;
import com.edu.iestpch.app.models.entity.Docente;

@Service
public class DocenteServiceImpl implements IDocenteService{
	
	@Autowired
	private IDocenteDao docenteDao;

	@Override
	@Transactional(readOnly=true)
	public List<Docente> findAll() {
		// TODO Auto-generated method stub
		return (List<Docente>) docenteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Docente docente) {
		// TODO Auto-generated method stub
		docenteDao.save(docente);
	}

	@Override
	@Transactional(readOnly=true)
	public Docente findOne(Long id) {
		// TODO Auto-generated method stub
		return docenteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		docenteDao.deleteById(id);
	}

}

package com.edu.iestpch.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.iestpch.app.models.dao.IModuloDao;
import com.edu.iestpch.app.models.entity.Modulo;

@Service
public class ModuloServiceImpl implements IModuloService{

	@Autowired
	private IModuloDao moduloDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Modulo> findAll() {
		// TODO Auto-generated method stub
		return (List<Modulo>) moduloDao.findAll();
	}

	@Override
	@Transactional
	public Page<Modulo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return moduloDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Modulo modulo) {
		// TODO Auto-generated method stub
		moduloDao.save(modulo);
	}

	@Override
	@Transactional(readOnly=true)
	public Modulo findOne(Long id) {
		// TODO Auto-generated method stub
		return moduloDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		moduloDao.deleteById(id);
	}

}

package com.edu.iestpch.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.iestpch.app.models.dao.IUnidadDidacticaDao;
import com.edu.iestpch.app.models.entity.UnidadDidactica;

@Service
public class UnidadDidacticaServiceImpl  implements IUnidadDidacticaService{
	
	@Autowired
	private IUnidadDidacticaDao unidadDidacticaDao;

	@Override
	@Transactional(readOnly=true)
	public List<UnidadDidactica> findAll() {
		// TODO Auto-generated method stub
		return (List<UnidadDidactica>) unidadDidacticaDao.findAll();
	}

	@Override
	@Transactional
	public void save(UnidadDidactica unidadDidactica) {
		// TODO Auto-generated method stub
		unidadDidacticaDao.save(unidadDidactica);
	}

	@Override
	@Transactional(readOnly=true)
	public UnidadDidactica findOne(Long id) {
		// TODO Auto-generated method stub
		return unidadDidacticaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		unidadDidacticaDao.deleteById(id);
	}

}

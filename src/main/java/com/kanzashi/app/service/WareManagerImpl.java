package com.kanzashi.app.service;

import java.util.List;

import com.kanzashi.app.dao.WareDAO;
import com.kanzashi.app.model.WareBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanzashi.app.model.CatalogBean;

@Service
public class WareManagerImpl implements WareManager {

	@Autowired
	WareDAO dao;
	
	public List<WareBean> getAllWares() {
		return dao.getAllWares();
	}

	public List<CatalogBean> getAllDepartments() {
		return dao.getAllDepartments();
	}

	public void addEmployee(WareBean ware) {
		dao.addWare(ware);
	}
}

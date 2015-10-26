package com.kanzashi.app.service;

import java.util.List;

import com.kanzashi.app.model.CatalogBean;
import com.kanzashi.app.model.WareBean;

public interface WareManager
{
	public List<WareBean> getAllWares();
	public List<CatalogBean> getAllDepartments();
	public void addEmployee(WareBean ware);
}

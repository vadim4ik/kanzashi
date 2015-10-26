package com.kanzashi.app.dao;

import com.kanzashi.app.model.CatalogBean;
import com.kanzashi.app.model.WareBean;

import java.util.List;

public interface WareDAO
{
	public List<WareBean> getAllWares();
	public List<CatalogBean> getAllDepartments();
	public void addWare(WareBean ware);
}
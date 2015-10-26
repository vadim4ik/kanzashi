package com.kanzashi.app.dao;

import com.kanzashi.app.model.CatalogBean;
import com.kanzashi.app.model.WareBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class WareDAOImpl implements WareDAO
{
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<WareBean> getAllWares()
	{
		List<WareBean> wares = manager.createNativeQuery("Select a.* From wares a", WareBean.class).getResultList();
        return wares;
	}
	
	public List<CatalogBean> getAllDepartments()
	{
		List<CatalogBean> depts = manager.createNativeQuery("Select a.* From catalog a", CatalogBean.class).getResultList();
        return depts;
	}
	
	public CatalogBean getDepartmentById(Long id)
	{
        return manager.find(CatalogBean.class, id);
	}
	
	public void addWare(WareBean ware)
	{
		//Use null checks and handle them
		ware.setCatalog(getDepartmentById(ware.getCatalog().getId()));
		manager.persist(ware);
	}
	
}
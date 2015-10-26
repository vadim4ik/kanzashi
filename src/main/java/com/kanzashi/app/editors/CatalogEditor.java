package com.kanzashi.app.editors;

import com.kanzashi.app.model.CatalogBean;

import java.beans.PropertyEditorSupport;

public class CatalogEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String id) 
    {
    	CatalogBean d;
    	switch(Integer.parseInt(id))
		{
			case 1: d = new CatalogBean(1L,  "Human Resource", 1L); break;
			case 2: d = new CatalogBean(2L,  "Finance", 1L); break;
			case 3: d = new CatalogBean(3L,  "Information Technology", 1L); break;
			default: d = null;
		}
        this.setValue(d);
    }
}

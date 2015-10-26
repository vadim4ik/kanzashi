package com.kanzashi.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="catalog")
public class CatalogBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="catalog_seq", sequenceName="catalog_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="catalog_seq")
	private Long id;
	private String name;
	private Long parentId;

	public CatalogBean(){

	}

	public CatalogBean(Long id, String name, Long parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	@OneToMany(mappedBy="catalog",cascade=CascadeType.PERSIST)
	private List<WareBean> WareBean = new ArrayList<WareBean>();

	public List<WareBean> getWareBean() {
		return WareBean;
	}
	public void setWareBean(List<WareBean> WareBean) {
		this.WareBean = WareBean;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "CatalogVO [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}

}

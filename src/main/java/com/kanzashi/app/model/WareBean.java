package com.kanzashi.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table (name="wares")
public class WareBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="wares_seq", sequenceName="wares_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="wares_seq")    private Long id;

	@NotEmpty
	private String name;
	private String shortName;
	private String image;

	@NotNull
	@ManyToOne
	private CatalogBean catalog;

	public WareBean() {}

	public WareBean(String name, String shortName, String image, CatalogBean catalog) {
		this.name = name;
		this.shortName = shortName;
		this.image = image;
		this.catalog = catalog;
	}

	public WareBean(String name) {
		this.name = name;
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

	public String getShortName() {
		return shortName;
	}

	public void setLastName(String shortName) {
		this.shortName = shortName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CatalogBean getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogBean catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return "WaresVO [id=" + id + ", name=" + name
				+ ", shortName=" + shortName + ", image=" + image
				+ ", catalog=" + catalog + "]";
	}

}
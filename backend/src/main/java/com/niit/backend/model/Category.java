package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="CATEGORY")/*in h2 category table=name*/
@Component
public class Category {
@Id
	private String id;
	private String name;
	private String description;
	
	/*mapping new name in description(instead of description some thing like "desc" )column in database @column(name="description")*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

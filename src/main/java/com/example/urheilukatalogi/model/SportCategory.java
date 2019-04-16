package com.example.urheilukatalogi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SportCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sportcatid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sportcategory")
	private List<Sport> sports;
	
	public SportCategory() {
		super();
	}

	public SportCategory(String name) {
		super();
		this.name = name;
	}

	public Long getSportcatid() {
		return sportcatid;
	}

	public void setSportcatid(Long sportcatid) {
		this.sportcatid = sportcatid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "SportCategory [sportcatid=" + sportcatid + ", name=" + name + "]";
	}
	
	
	
}

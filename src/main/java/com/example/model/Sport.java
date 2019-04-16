package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sport {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String team, result, standing;
	private int date;
	

	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "sportcatid")
    private SportCategory sportcategory;
	
	
	public Sport() {
		super();
	}
	
	public Sport(Long id, String team, String result, String standing, int date) {
		super();
		this.id = id;
		this.team = team;
		this.result = result;
		this.standing = standing;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getStanding() {
		return standing;
	}
	public void setStanding(String standing) {
		this.standing = standing;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", team=" + team + ", result=" + result + ", standing=" + standing + ", date=" + date
				+ "]";
	}
	
}

package com.example.urheilukatalogi.model;

import javax.persistence.Column;
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
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column 
	private Long id;
	@Column
	private String team, country, win, lose, standing;
	

	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "sportcatid")
    private SportCategory sportcategory;
	
	
	public Sport() {
		super();
	}
	
	public Sport(String team, String country, String win, String lose, SportCategory sportcategory) {
		super();
		this.team = team;
		this.country = country;
		this.win = win;
		this.lose = lose;
		this.sportcategory = sportcategory;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	
	public String getLose() {
		return lose;
	}

	public void setLose(String lose) {
		this.lose = lose;
	}

	public SportCategory getSportcategory() {
		return sportcategory;
	}

	public void setSportcategory(SportCategory sportcategory) {
		this.sportcategory = sportcategory;
	}

	@Override
	public String toString() {
		if (this.sportcategory != null)
		return "Sport [id=" + id + ", team=" + team + ", country=" + country  + ", win=" + win + 
				",  lose=" + lose + this.getSportcategory() + "]";
		else
			return "Sport [id=" + id + ", team=" + team + ", country=" + country + ", win=" + win
				+ ", lose=" + lose + "]";
	}
	
	
}

package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="PlayerDB")
public class PlayerDto {
/*	
	@Id
	@GeneratedValue
	@Column(name = "IpLID" )
	private Long id;*/
	@Id
	@Column(name = "Name"  )
	private String name;
	@Column(name = "role" )
	private String role;
	@Column(name = "batting" )
	private String batting;
	@Column(name = "bowler" )
	private String bowler;
	@Column(name = "nation")
	private String nation;
	@Column(name = "dob" )
	private String dob;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBatting() {
		return batting;
	}
	public void setBatting(String batting) {
		this.batting = batting;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
}

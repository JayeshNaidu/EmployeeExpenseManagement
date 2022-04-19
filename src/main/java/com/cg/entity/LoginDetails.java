package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LoginDetails")
public class LoginDetails {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="lUserName")
	private String lUserName;
	@Column(name="lPassword")
	private String lPassword;
	@Column(name="lRole")
	private String lRole;
	
	public LoginDetails() {
		super();
	}

	public LoginDetails(int id, String lUserName, String lPassword, String lRole) {
		super();
		this.id = id;
		this.lUserName = lUserName;
		this.lPassword = lPassword;
		this.lRole = lRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getlUserName() {
		return lUserName;
	}

	public void setlUserName(String lUserName) {
		this.lUserName = lUserName;
	}

	public String getlPassword() {
		return lPassword;
	}

	public void setlPassword(String lPassword) {
		this.lPassword = lPassword;
	}

	public String getlRole() {
		return lRole;
	}

	public void setlRole(String lRole) {
		this.lRole = lRole;
	}

	@Override
	public String toString() {
		return "LoginDetails [id=" + id + ", lUserName=" + lUserName + ", lPassword=" + lPassword + ", lRole=" + lRole
				+ "]";
	}

	
	
}

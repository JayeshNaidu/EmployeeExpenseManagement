package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Project")
public class Project {
	@Id
	@Column(name="projectCode")
	private int projectCode;
	@Column(name = "projectDescription")
	private String projectDescription;
	@Column(name = "startDate")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@Column(name = "endDate")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;

	public Project() {
		super();
	}

	public Project(int projectCode, String projectDescription, LocalDate startDate, LocalDate endDate) {
		super();
		this.projectCode = projectCode;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Project [projectCode=" + projectCode + ", projectDescription=" + projectDescription + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

}

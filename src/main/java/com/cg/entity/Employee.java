package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="empId")
	private int empId;
	
	@NotBlank(message="Name cannot be empty")
	@Column(name="empName")
	private String empName;
	
	@NotBlank(message="PAN cannot be empty")
	@Size(min=1,max=10)
	@Column(name="empPAN")
	private String empPAN;
	
	@NotBlank(message="Designation cannot be empty")
	@Column(name="empDesignation")
	private String empDesignation;
	
	@Column(name="empDomain")
	@NotBlank(message="Domain cannot be empty")
	private String empDomain;
	
	@NotBlank(message="Date of joining cannot be empty")
	@Column(name="empDOJ")
	private String empDOJ;
	
	@NotBlank(message="Date of birth cannot be empty")
	@Column(name="empDOB")
	private String empDOB;
	
	@NotNull(message="Salary cannot be empty")
	@Min(value=1)
	@Column(name="empSalary")
	private double empSalary;
	
	@Email
	@NotBlank(message="Email cannot be empty")
	@Column(name="empEmailId")
	private String empEmailId;
	
	@NotBlank(message="Username cannot be empty")
	@Column(name="userName")
	private String userName;
	
	@NotBlank(message="Password cannot be empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="Role cannot be empty")
	@Column(name="role")
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	protected LoginDetails logindetails;
	
	public Employee() {
		super();
	}

	

	public Employee(int empId, @NotBlank(message = "Name cannot be empty") String empName,
			@NotBlank(message = "PAN cannot be empty") @Size(min = 1, max = 10) String empPAN,
			@NotBlank(message = "Designation cannot be empty") String empDesignation,
			@NotBlank(message = "Domain cannot be empty") String empDomain,
			@NotBlank(message = "Date of joining cannot be empty") String empDOJ,
			@NotBlank(message = "Date of birth cannot be empty") String empDOB,
			@NotNull(message = "Salary cannot be empty") @Min(1) double empSalary,
			@Email @NotBlank(message = "Email cannot be empty") String empEmailId,
			@NotBlank(message = "Username cannot be empty") String userName,
			@NotBlank(message = "Password cannot be empty") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$") String password,
			@NotBlank(message = "Role cannot be empty") String role, LoginDetails logindetails) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPAN = empPAN;
		this.empDesignation = empDesignation;
		this.empDomain = empDomain;
		this.empDOJ = empDOJ;
		this.empDOB = empDOB;
		this.empSalary = empSalary;
		this.empEmailId = empEmailId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.logindetails = logindetails;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPAN() {
		return empPAN;
	}

	public void setEmpPAN(String empPAN) {
		this.empPAN = empPAN;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDomain() {
		return empDomain;
	}

	public void setEmpDomain(String empDomain) {
		this.empDomain = empDomain;
	}

	public String getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(String empDOJ) {
		this.empDOJ = empDOJ;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LoginDetails getLogindetails() {
		return logindetails;
	}

	public void setLogindetails(LoginDetails logindetails) {
		this.logindetails = logindetails;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPAN=" + empPAN + ", empDesignation="
				+ empDesignation + ", empDomain=" + empDomain + ", empDOJ=" + empDOJ + ", empDOB=" + empDOB
				+ ", empSalary=" + empSalary + ", empEmailId=" + empEmailId + ", userName=" + userName + ", password="
				+ password + ", role=" + role + ", logindetails=" + logindetails + "]";
	}

	
	
}

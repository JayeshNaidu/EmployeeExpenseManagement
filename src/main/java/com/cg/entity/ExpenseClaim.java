package com.cg.entity;

import java.time.LocalDate;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ExpenseClaim")
public class ExpenseClaim {
	@Id
	@Column(name="expenseClaimId")
	private int expenseClaimId;
	
	@NotNull(message="Amount cannot be empty")
	@Min(value=0) 
	@Column(name = "expenseAmount")
	private double expenseAmount;
	
	@Column(name = "startDate")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	
	@Column(name = "endDate")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;

//	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "exClaimExpenseCode")
	protected Expense expense;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "exClaimProjectCode")
	protected Project project;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "exClaimEmpCode")
	protected Employee employee;

	public ExpenseClaim() {
		super();
	}

	public ExpenseClaim(int expenseClaimId, @NotNull(message = "Amount cannot be empty") @Min(0) double expenseAmount,
			LocalDate startDate, LocalDate endDate, Expense expense, Project project, Employee employee) {
		super();
		this.expenseClaimId = expenseClaimId;
		this.expenseAmount = expenseAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.expense = expense;
		this.project = project;
		this.employee = employee;
	}

	public int getExpenseClaimId() {
		return expenseClaimId;
	}

	public void setExpenseClaimId(int expenseClaimId) {
		this.expenseClaimId = expenseClaimId;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
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

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ExpenseClaim [expenseClaimId=" + expenseClaimId + ", expenseAmount=" + expenseAmount + ", startDate="
				+ startDate + ", endDate=" + endDate + ", expense=" + expense + ", project=" + project + ", employee="
				+ employee + "]";
	}

	
}

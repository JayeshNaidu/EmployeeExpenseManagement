package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Expense")
public class Expense {
	@Id
	@Column(name="expenseCode")
	private int expenseCode;
	
	@NotBlank(message="Type cannot be empty")
	@Column(name="expenseType")
	private String expenseType;
	
	@NotBlank(message="Description cannot be empty")
	@Column(name="expenseDescription")
	private String expenseDescription;
	
	public Expense() {
		super();
	}
	
	public Expense(int expenseCode, String expenseType, String expenseDescription) {
		super();
		this.expenseCode = expenseCode;
		this.expenseType = expenseType;
		this.expenseDescription = expenseDescription;
	}
	
	
	public int getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseDescription() {
		return expenseDescription;
	}
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	@Override
	public String toString() {
		return "Expense [expenseCode=" + expenseCode + ", expenseType=" + expenseType + ", expenseDescription="
				+ expenseDescription + "]";
	}
	
	
	
}

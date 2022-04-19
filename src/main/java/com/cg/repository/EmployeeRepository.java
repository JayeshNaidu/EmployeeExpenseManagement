package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Employee;


	@Repository
	public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
		public boolean existsByEmpEmailId(String email);

		public Employee findByEmpName(String string);
}

package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	@Query("select projectCode from Project")
	List<Integer> getAllProjectCodes();

	boolean existsByProjectDescription(String projDesc);

	boolean existsByProjectCode(int projectCode);

	Project findByProjectDescription(String string);
	
	

}

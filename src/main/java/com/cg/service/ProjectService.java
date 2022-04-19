package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Project;
import com.cg.exception.LoginDetailsException;
import com.cg.exception.ProjectException;
import com.cg.repository.ExpenseClaimRepository;
import com.cg.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private ExpenseClaimRepository exClaimRepo;

	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}

//	public Project addProject(Project project) {
//		return projectRepo.save(project);
//	}

	public Project addProject(Project project) {
		String ProjDesc = project.getProjectDescription();
		LocalDate startDate = project.getStartDate();
		LocalDate endDate = project.getEndDate();
		int projectId = project.getProjectCode();
		String designation = exClaimRepo.findExpenseClaimByProjectProjectCode(projectId).getEmployee().getEmpDesignation();
		try {
			if (!designation.equals("Admin")) {
				throw new ProjectException("You are not authorized to add project");
			} else if (projectRepo.existsByProjectDescription(ProjDesc)) {
				throw new ProjectException("Project already exists!");
			} else if (startDate.isAfter(endDate)) {
				throw new ProjectException("Start date is after End date! Please enter appropriate dates");
			} else {
				return projectRepo.save(project);
			}
		} catch (ProjectException ex) {
			throw ex;
		}

	}

	public Project updateProject(Project project) {
		int projectId = project.getProjectCode();
		String designation = exClaimRepo.findExpenseClaimByProjectProjectCode(projectId).getEmployee().getEmpDesignation();
		try {
			if (designation.equals("Admin")) {
				return projectRepo.save(project);
			} else {
				throw new ProjectException("You are not authorized to update project");
			}
		} catch (ProjectException ex) {
			throw ex;
		}

	}

	// cannot delete project as it violates foreign key constraint.
	// first Delete parent then child

	// modification: Return type to String
	public String deleteProjectById(int id) {
		projectRepo.deleteById(id);
		return "Record deleted successfully!";
	}

	public List<Integer> getAllProjectCodes() {
		try {
			int check = (int) projectRepo.count();
			if (check < 1) {
				throw new ProjectException("No projects added !");
			} else {
				return projectRepo.getAllProjectCodes();
			}
		} catch (LoginDetailsException ex) {
			throw ex;
		}

		// return projectRepo.getAllProjectCodes();
	}

	public Project findProjectByCode(int projectCode) {
		try {
			if (!projectRepo.existsByProjectCode(projectCode)) {
				throw new ProjectException("ProjectCode does not exist!");
			} else {
				return projectRepo.findById(projectCode).get();
			}
		} catch (ProjectException ex) {
			throw ex;
		}

	}

}

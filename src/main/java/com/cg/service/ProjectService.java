package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Project;
import com.cg.exception.LoginDetailsException;
import com.cg.exception.ProjectException;
import com.cg.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;

	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}

	public Project addProject(Project project) {
		String ProjDesc = project.getProjectDescription();
		LocalDate startDate = project.getStartDate();
		LocalDate endDate = project.getEndDate();
		try {
			if (projectRepo.existsByProjectDescription(ProjDesc)) {
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
		return projectRepo.save(project);
	}

	// modification: Return type to String
	public String deleteProjectById(int id) {
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
	}

	public Project findProjectByCode(int projectCode) {

		return projectRepo.findById(projectCode).get();

	}

	// Test Specific Methods
	public Project addProjectTest(Project p) {
		return projectRepo.save(p);
	}

	public Project getProjectDescription(Project p) {
		return projectRepo.findByProjectDescription(p.getProjectDescription());
	}

	public Project testUpdateProjectFunction(Project p) {
		return projectRepo.save(p);
	}

	public void deleteProject(Project p) {
		projectRepo.delete(p);
	}

}

package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Project;
import com.cg.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService pService;

	@GetMapping("/getAllProject")
	public List<Project> getAllProject() {
		return pService.getAllProject();
	}

	@PostMapping("/addProject")
	public Project addProject(@RequestBody Project project) {
		return pService.addProject(project);
	}

	@PostMapping("/updateProject")
	public Project updateProject(@RequestBody Project project) {
		return pService.updateProject(project);
	}

	@DeleteMapping("/deleteProjectById/{id}")
	public String deleteProjectById(@PathVariable("id") int id) {
		return pService.deleteProjectById(id);
	}

	@GetMapping("/getAllProjectCodes")
	public List<Integer> getAllProjectCodes() {
		return pService.getAllProjectCodes();
	}

	@GetMapping("/findProjectByCode/{code}")
	public Project findProjectByCode(@PathVariable("code") int code) {
		return pService.findProjectByCode(code);
	}

}

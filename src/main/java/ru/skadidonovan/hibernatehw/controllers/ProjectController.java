package ru.skadidonovan.hibernatehw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;
import ru.skadidonovan.hibernatehw.services.ProjectService;
import ru.skadidonovan.hibernatehw.services.impl.ProjectServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public List<Project> getAll() {
        List<Project> projects = projectService.getAll();
        return projects;
    }

    @GetMapping("/{id}")
    public Project getOne(@PathVariable long id) {

        return projectService.getOne(id);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody Project project) {
        if(projectService.save(project))
            return ResponseEntity.ok(HttpStatus.OK);
         else
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody Project project,
                                             @PathVariable long id) {
        projectService.update(id, project);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        projectService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeeProjects(@RequestParam String projectName){
        return projectService.getProjectEmployees(projectName);
    }
}

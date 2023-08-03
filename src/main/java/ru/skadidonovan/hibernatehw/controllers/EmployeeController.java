package ru.skadidonovan.hibernatehw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;
import ru.skadidonovan.hibernatehw.services.impl.EmployeeService;
import ru.skadidonovan.hibernatehw.services.impl.ProjectService;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ProjectService projectService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping()
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable long id) {

        return employeeService.getOne(id);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody Employee employee) {
        if(employeeService.save(employee))
            return ResponseEntity.ok(HttpStatus.OK);
         else
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody Employee employee,
                                             @PathVariable long id) {
        employeeService.update(id, employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        employeeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/projects")
    public List<Project> getEmployeeProjects(@RequestParam String lastName){
        return employeeService.getEmployeeProject(lastName);
    }
}

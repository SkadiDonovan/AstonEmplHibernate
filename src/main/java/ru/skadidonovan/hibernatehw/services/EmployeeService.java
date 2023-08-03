package ru.skadidonovan.hibernatehw.services;

import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

public interface EmployeeService extends DefaultService<Employee, Long>{

    List<Project> getEmployeeProject(String lastName);
}

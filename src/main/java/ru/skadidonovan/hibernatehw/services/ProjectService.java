package ru.skadidonovan.hibernatehw.services;

import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

public interface ProjectService extends DefaultService<Project, Long>{

    List<Employee> getProjectEmployees(String projectName);
}

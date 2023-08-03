package ru.skadidonovan.hibernatehw.dao;

import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

public interface ProjectDAO extends DefaultDAO<Project, Long>{

    List<Employee> getProjectEmployees(String projectName);
}

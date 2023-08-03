package ru.skadidonovan.hibernatehw.dao;

import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;
import java.util.List;

public interface EmployeeDAO extends DefaultDAO<Employee, Long>{
    List<Project> getEmployeeProject(String lastName);
}

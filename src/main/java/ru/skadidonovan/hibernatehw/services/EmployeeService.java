package ru.skadidonovan.hibernatehw.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skadidonovan.hibernatehw.dao.EmployeeDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAll(){
        return employeeDAO.getAll();
    }


    public Employee getOne(long id) {
        return employeeDAO.getOne(id);
    }

    public boolean save(Employee employee) {
        employeeDAO.save(employee);
        return true;
    }

    public boolean update(long id, Employee employee) {
        return employeeDAO.update(id, employee);
    }

    public boolean delete(long id) {
        return employeeDAO.delete(id);
    }

    public List<Project> getEmployeeProject(String lastName) {
        return employeeDAO.getEmployeeProject(lastName);
    }
}

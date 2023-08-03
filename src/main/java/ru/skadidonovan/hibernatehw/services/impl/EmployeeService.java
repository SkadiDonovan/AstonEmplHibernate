package ru.skadidonovan.hibernatehw.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.DefaultDAO;
import ru.skadidonovan.hibernatehw.dao.EmployeeDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

@Service
@Transactional(readOnly = true)
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

    @Transactional
    public boolean save(Employee employee) {
        employeeDAO.save(employee);
        return true;
    }

    @Transactional
    public boolean update(Long id, Employee employee) {
        return employeeDAO.update(id, employee);
    }

    @Transactional
    public boolean delete(long id) {
        return employeeDAO.delete(id);
    }

    public List<Project> getEmployeeProject(String lastName) {
        return employeeDAO.getEmployeeProject(lastName);
    }
}

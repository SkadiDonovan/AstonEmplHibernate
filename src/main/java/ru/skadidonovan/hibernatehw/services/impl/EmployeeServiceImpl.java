package ru.skadidonovan.hibernatehw.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.EmployeeDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;
import ru.skadidonovan.hibernatehw.services.EmployeeService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAll(){
        return employeeDAO.getAll();
    }


    @Override
    public Employee getOne(Long id) {
        return employeeDAO.getOne(id);
    }

    @Override
    @Transactional
    public boolean save(Employee employee) {
        employeeDAO.save(employee);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Long id, Employee employee) {
        return employeeDAO.update(id, employee);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return employeeDAO.delete(id);
    }

    @Override
    public List<Project> getEmployeeProject(String lastName) {
        return employeeDAO.getEmployeeProject(lastName);
    }
}

package ru.skadidonovan.hibernatehw.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

@Component
public class EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select e from Employee e left join fetch e.position" +
                        " left join fetch e.projects", Employee.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Employee getOne(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Employee.class, id);
    }

    @Transactional
    public boolean save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(employee);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Transactional
    public boolean update(Long id, Employee updatedEmployee){
        Session session = sessionFactory.getCurrentSession();
        Employee employeeToBeUpdated = session.get(Employee.class, id);

        employeeToBeUpdated.setFirstName(updatedEmployee.getFirstName());
        employeeToBeUpdated.setLastName(updatedEmployee.getLastName());
        employeeToBeUpdated.setPosition(updatedEmployee.getPosition());

        session.save(employeeToBeUpdated);
        return true;
    }

    @Transactional
    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Employee.class, id));
        return true;
    }

    @Transactional(readOnly = true)
    public List<Project> getEmployeeProject(String lastName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee e where e.lastName=:lastName", Employee.class);
        query.setParameter("lastName", lastName);
        Employee employee = query.uniqueResult();
        return employee.getProjects();
    }
}

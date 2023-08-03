package ru.skadidonovan.hibernatehw.dao.impl;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.skadidonovan.hibernatehw.dao.EmployeeDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select e from Employee e left join fetch e.position" +
                        " left join fetch e.projects", Employee.class)
                .getResultList();
    }

    @Override
    public Employee getOne(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Employee.class, id);
    }

    @Override
    public boolean save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(employee);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean update(Long id, Employee updatedEmployee){
        Session session = sessionFactory.getCurrentSession();
        Employee employeeToBeUpdated = session.get(Employee.class, id);

        employeeToBeUpdated.setFirstName(updatedEmployee.getFirstName());
        employeeToBeUpdated.setLastName(updatedEmployee.getLastName());
        employeeToBeUpdated.setPosition(updatedEmployee.getPosition());

        session.save(employeeToBeUpdated);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Employee.class, id));
        return true;
    }

    @Override
    public List<Project> getEmployeeProject(String lastName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee e where e.lastName=:lastName", Employee.class);
        query.setParameter("lastName", lastName);
        Employee employee = query.uniqueResult();
        return employee.getProjects();
    }
}

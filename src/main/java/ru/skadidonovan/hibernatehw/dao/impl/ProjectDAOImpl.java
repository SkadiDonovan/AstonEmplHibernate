package ru.skadidonovan.hibernatehw.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.ProjectDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Project> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select pr from Project pr", Project.class)
                .getResultList();
    }

    @Override
    public Project getOne(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Project.class, id);
    }

    @Override
    public boolean save(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.save(project);
        return true;
    }

    @Override
    public boolean update(Long id, Project updatedProject) {
        Session session = sessionFactory.getCurrentSession();
        Project projectToBeUpdated = session.get(Project.class, id);

        projectToBeUpdated.setProjectName(updatedProject.getProjectName());

        session.save(projectToBeUpdated);

        return true;
    }

    @Override
    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Project.class, id));
        return true;
    }

    @Override
    public List<Employee> getProjectEmployees(String projectName){
        Session session = sessionFactory.getCurrentSession();
        Query<Project> query = session.createQuery("from Project p where p.projectName=:projectName", Project.class);
        query.setParameter("projectName", projectName);
        Project project = query.uniqueResult();
        return project.getEmployees();
    }
}

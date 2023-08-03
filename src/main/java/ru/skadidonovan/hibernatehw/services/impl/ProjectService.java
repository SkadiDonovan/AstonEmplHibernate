package ru.skadidonovan.hibernatehw.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.impl.ProjectDAOImpl;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectService {
    private final ProjectDAOImpl projectDAOImpl;

    @Autowired
    public ProjectService(ProjectDAOImpl positionDAO) {
        this.projectDAOImpl = positionDAO;
    }

    public List<Project> getAll(){
        return projectDAOImpl.getAll();
    }


    public Project getOne(long id) {
        return projectDAOImpl.getOne(id);
    }

    @Transactional
    public boolean save(Project project) {
        projectDAOImpl.save(project);
        return true;
    }

    @Transactional
    public boolean update(long id, Project project) {
        return projectDAOImpl.update(id, project);
    }

    @Transactional
    public boolean delete(long id) {
        return projectDAOImpl.delete(id);
    }

    public List<Employee> getProjectEmployees(String projectName) {
        return projectDAOImpl.getProjectEmployees(projectName);
    }
}

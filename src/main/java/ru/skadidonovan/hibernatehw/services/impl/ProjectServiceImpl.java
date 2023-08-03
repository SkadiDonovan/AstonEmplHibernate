package ru.skadidonovan.hibernatehw.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.ProjectDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;
import ru.skadidonovan.hibernatehw.services.ProjectService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDAO positionDAO) {
        this.projectDAO = positionDAO;
    }

    @Override
    public List<Project> getAll(){
        return projectDAO.getAll();
    }

    @Override
    public Project getOne(Long id) {
        return projectDAO.getOne(id);
    }

    @Override
    @Transactional
    public boolean save(Project project) {
        projectDAO.save(project);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Long id, Project project) {
        return projectDAO.update(id, project);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return projectDAO.delete(id);
    }

    @Override
    public List<Employee> getProjectEmployees(String projectName) {
        return projectDAO.getProjectEmployees(projectName);
    }
}

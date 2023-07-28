package ru.skadidonovan.hibernatehw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skadidonovan.hibernatehw.dao.PositionDAO;
import ru.skadidonovan.hibernatehw.dao.ProjectDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO positionDAO) {
        this.projectDAO = positionDAO;
    }

    public List<Project> getAll(){
        return projectDAO.getAll();
    }


    public Project getOne(long id) {
        return projectDAO.getOne(id);
    }

    public boolean save(Project project) {
        projectDAO.save(project);
        return true;
    }

    public boolean update(long id, Project project) {
        return projectDAO.update(id, project);
    }

    public boolean delete(long id) {
        return projectDAO.delete(id);
    }

    public List<Employee> getProjectEmployees(String projectName) {
        return projectDAO.getProjectEmployees(projectName);
    }
}

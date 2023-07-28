package ru.skadidonovan.hibernatehw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.PositionDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;

import java.util.List;

@Service
public class PositionService {
    private final PositionDAO positionDAO;

    @Autowired
    public PositionService(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    public List<Position> getAll(){
        return positionDAO.getAll();
    }


    public Position getOne(Long id) {
        return positionDAO.getOne(id);
    }

    public boolean save(Position position) {
        positionDAO.save(position);
        return true;
    }

    public boolean update(long id, Position position) {
        return positionDAO.update(id, position);
    }

    public boolean delete(long id) {
        return positionDAO.delete(id);
    }

    public List<Employee> getPositionEmployees(String positionName) {
        return positionDAO.getPositionEmployees(positionName);
    }
}

package ru.skadidonovan.hibernatehw.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.PositionDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;

import java.util.List;

@Service
@Transactional(readOnly = true)
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

    @Transactional
    public boolean save(Position position) {
        positionDAO.save(position);
        return true;
    }

    @Transactional
    public boolean update(Long id, Position position) {
        return positionDAO.update(id, position);
    }

    @Transactional
    public boolean delete(Long id) {
        return positionDAO.delete(id);
    }

    public List<Employee> getPositionEmployees(String positionName) {
        return positionDAO.getPositionEmployees(positionName);
    }
}

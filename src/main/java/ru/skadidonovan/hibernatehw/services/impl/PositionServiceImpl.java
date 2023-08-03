package ru.skadidonovan.hibernatehw.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.PositionDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;
import ru.skadidonovan.hibernatehw.services.PositionService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PositionServiceImpl implements PositionService {
    private final PositionDAO positionDAO;

    @Autowired
    public PositionServiceImpl(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @Override
    public List<Position> getAll(){
        return positionDAO.getAll();
    }


    @Override
    public Position getOne(Long id) {
        return positionDAO.getOne(id);
    }

    @Override
    @Transactional
    public boolean save(Position position) {
        positionDAO.save(position);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Long id, Position position) {
        return positionDAO.update(id, position);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return positionDAO.delete(id);
    }

    @Override
    public List<Employee> getPositionEmployees(String positionName) {
        return positionDAO.getPositionEmployees(positionName);
    }
}

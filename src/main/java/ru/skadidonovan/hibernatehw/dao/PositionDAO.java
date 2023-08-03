package ru.skadidonovan.hibernatehw.dao;

import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

public interface PositionDAO extends DefaultDAO<Position, Long>{
    List<Employee> getPositionEmployees(String positionName);
}

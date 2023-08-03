package ru.skadidonovan.hibernatehw.services;

import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;

import java.util.List;

public interface PositionService extends DefaultService<Position, Long>{

    List<Employee> getPositionEmployees(String positionName);
}

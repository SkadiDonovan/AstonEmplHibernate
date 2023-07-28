package ru.skadidonovan.hibernatehw.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;
import ru.skadidonovan.hibernatehw.models.Project;
import ru.skadidonovan.hibernatehw.services.PositionService;

import java.util.List;

@Component
public class PositionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PositionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Position> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select e from Position e", Position.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Position getOne(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Position.class, id);
    }

    @Transactional
    public boolean save(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.save(position);
        return true;
    }

    @Transactional
    public boolean update(Long id, Position updatedPosition) {
        Session session = sessionFactory.getCurrentSession();
        Position positionToBeUpdated = session.get(Position.class, id);

        positionToBeUpdated.setPositionName(updatedPosition.getPositionName());

        session.save(positionToBeUpdated);

        return true;
    }

    @Transactional
    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Position.class, id));
        return true;
    }

    @Transactional
    public List<Employee> getPositionEmployees(String positionName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Position> query = session.createQuery("from Position p where p.positionName=:positionName", Position.class);
        query.setParameter("positionName", positionName);
        Position position = query.uniqueResult();
        return position.getEmployees();
    }
}

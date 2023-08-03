package ru.skadidonovan.hibernatehw.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.dao.PositionDAO;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;

import java.util.List;

@Repository
public class PositionDAOImpl implements PositionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PositionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Position> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select e from Position e", Position.class)
                .getResultList();
    }

    @Override

    public Position getOne(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Position.class, id);
    }

    @Override
    public boolean save(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.save(position);
        return true;
    }

    @Override
    public boolean update(Long id, Position updatedPosition) {
        Session session = sessionFactory.getCurrentSession();
        Position positionToBeUpdated = session.get(Position.class, id);

        positionToBeUpdated.setPositionName(updatedPosition.getPositionName());

        session.save(positionToBeUpdated);

        return true;
    }

    @Override
    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Position.class, id));
        return true;
    }

    @Override
    public List<Employee> getPositionEmployees(String positionName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Position> query = session.createQuery("from Position p where p.positionName=:positionName", Position.class);
        query.setParameter("positionName", positionName);
        Position position = query.uniqueResult();
        return position.getEmployees();
    }
}

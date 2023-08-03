package ru.skadidonovan.hibernatehw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Project;

import java.util.List;

public interface DefaultDAO<T,ID> {
    List<T> getAll();
    T getOne(ID id);

    boolean save(T t) ;

    boolean update(ID id, T updatedT);
    boolean delete(ID id);

}

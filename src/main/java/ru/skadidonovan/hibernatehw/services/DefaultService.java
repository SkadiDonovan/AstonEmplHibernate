package ru.skadidonovan.hibernatehw.services;

import java.util.List;

public interface DefaultService<T, ID> {
    List<T> getAll();
    T getOne(ID id);

    boolean save(T t) ;

    boolean update(ID id, T updatedT);
    boolean delete(ID id);
}

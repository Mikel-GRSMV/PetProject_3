package ru.folder.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T>{
    Optional<T> find(Integer id); //найти по id
    void save(T model); //сохранить в БД
    void update(T model); //обновить
    void delete(Integer id); //удалить

    List<T> findAll();//найти все
}

package bbc.news.jenny.repository;

import java.util.List;


interface Repository<T> {

    List<T> load();

    void save(List<T> listOfObjects);

    void delete(T obj);
}

package bbc.news.jenny.repository;

import java.util.List;


interface Repository<T> {

    List<T> load();

    int save(T obj);

    void delete(T obj);
}

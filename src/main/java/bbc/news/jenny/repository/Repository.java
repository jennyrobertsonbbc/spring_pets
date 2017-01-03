package bbc.news.jenny.repository;

import java.util.Map;

interface Repository<T> {

    Map<Integer,T> load();

    int save(T obj);

    void delete(T obj);
}

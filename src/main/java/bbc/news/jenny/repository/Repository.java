package bbc.news.jenny.repository;

interface Repository<T> {

//    Map<Integer,T> load();

    int save(T obj);

    void delete(T obj);
}

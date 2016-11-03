package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;

import java.util.List;


interface Repository<T> {

    List<T> load();

    void save(List<T> listOfPets);

    void delete(T obj);
}

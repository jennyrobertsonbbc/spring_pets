package repository;

import java.util.List;


interface Repository<T> {

    List<T> load();

    void save(List<T> listOfPets);
}

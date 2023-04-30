package airport_hibernate.service.abstract_service;

import java.util.Set;

public interface Service <T> {
    T getById(final long id);
    Set<T> getAll();
    Set<T> get(final int limit, final int offset, final String sort);
    void save(final T object);
    void update(final T object, final long id);
    void delete(final long id);
    String toString(final T object);
    default void print(final Set<T> set){
        for(T i: set){
            System.out.println(this.toString(i));
        }
    }
}
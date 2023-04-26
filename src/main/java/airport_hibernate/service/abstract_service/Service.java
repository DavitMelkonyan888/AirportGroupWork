package airport_hibernate.service.abstract_service;

import java.util.Set;

public interface Service <T> {
    public abstract T getById(long id);
    public abstract Set<T> getAll();
    public abstract Set<T> get(int offset, int perPage, String sort);
    public abstract void save(T object);
    public abstract void update(T object, long id);
    public abstract void delete(long id);
    public abstract String toString(T object);
}

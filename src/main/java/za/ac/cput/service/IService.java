package za.ac.cput.service;

public interface IService<T, ID> {
    T create(T t);
    T read(T id);
    T update (T t);
    boolean delete(T id);
}

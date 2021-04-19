package pl.malek.service;

import java.util.List;
import java.util.Optional;

public interface MethodInterface <T>{

    List<T> getAll();

    void add(T t);

    Optional<T> get(Long id);

    void delete(Long id);

    void update(T t);
}

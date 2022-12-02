package service;

import java.util.List;

public interface GenericService<T, ID> {

  T save(T t);

  T update(ID id, T t);

  T getById(ID id);

  List<T> getAll();

  void deleteById(ID id);
}

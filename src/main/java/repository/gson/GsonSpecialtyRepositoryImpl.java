package repository.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Specialty;
import repository.SpecialtyRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {
   @Override
  public Specialty save(Specialty specialty) {
    return null;
  }

  @Override
  public Specialty update(Long id, Specialty specialty) {
    return null;
  }

  @Override
  public Specialty getById(Long id) {
    return null;
  }

  @Override
  public List<Specialty> getAll() {
    return null;
  }

  @Override
  public void deleteById(Long id) {
  }
}

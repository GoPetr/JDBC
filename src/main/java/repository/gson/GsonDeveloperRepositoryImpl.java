package repository.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Developer;
import model.Skill;
import model.Status;
import repository.DeveloperRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
  @Override
  public Developer save(Developer developer) {
    return null;
  }

  @Override
  public Developer update(Long id, Developer developer) {
    return null;
  }

  @Override
  public Developer getById(Long id) {
    return null;
  }

  @Override
  public List<Developer> getAll() {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }
}


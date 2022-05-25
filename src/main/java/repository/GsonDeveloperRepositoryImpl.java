package repository;

import controller.JSONtoFileRepositoryImpl;
import model.Developer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository, Serializable {
  public ArrayList<Developer> developerList = new ArrayList<>();

  JSONtoFileRepositoryImpl json = new JSONtoFileRepositoryImpl();

  @Override
  public void save(Developer developer) {
    long countId = developerList.size() + 1;
    developer.setId(countId);
    developerList.add(developer);
    json.save(developer);
  }

  @Override
  public Developer getDeveloper(long id) {
    return null;
  }

  @Override
  public List<Developer> getAllDevelopers() {
    return developerList;
  }

  @Override
  public void delete(long id) {
  }
}


package repository;

import model.Developer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository, Serializable {
  public ArrayList<Developer> developerList = new ArrayList<>();

  @Override
  public void save(Developer developer) {
    developerList.add(developer);
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


  public ArrayList<Developer> getDeveloperList() {
    return developerList;
  }
}

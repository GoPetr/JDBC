package service.impl;

import model.Developer;
import repository.gson.GsonDeveloperRepositoryImpl;
import service.DeveloperService;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService {
  private final GsonDeveloperRepositoryImpl developerRepository = new GsonDeveloperRepositoryImpl();

  public Developer save(Developer developer) {
    return developerRepository.save(developer);
  }

  public Developer update(Long id, Developer developer) {
    return null;
  }

  public Developer getById(Long id) {
    return developerRepository.getById(id);
  }

  public List<Developer> getAll() {
    return developerRepository.getAll();
  }

  public void deleteById(Long id) {
    developerRepository.deleteById(id);
  }
}

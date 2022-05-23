package repository;

import model.Developer;

import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Long> {
  public Developer save(Developer developer);

  public Developer getDeveloper(long id);

  public List<Developer> getAllDevelopers();

  public void delete(long id);

}

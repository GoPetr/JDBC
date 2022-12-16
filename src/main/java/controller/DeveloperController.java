package controller;

import model.Developer;
import model.Skill;
import service.impl.DeveloperServiceImpl;

import java.util.List;

public class DeveloperController {
  private final DeveloperServiceImpl developerService = new DeveloperServiceImpl();

  public Developer createDeveloper(String firstName,
                                   String lastName,
                                   List<Skill> skills,
                                   String speciality) {
    Developer developer = new Developer();
    developer.setFirstName(firstName);
    developer.setLastName(lastName);
    developer.setSkills(skills);
    developer.setSpecialty(speciality);
    return developerService.save(developer);
  }

  public Developer updateDeveloper(Long id,
                                   String firstName,
                                   String lastName,
                                   List<Skill> skills,
                                   String speciality) {
    Developer developer = new Developer();
    developer.setFirstName(firstName);
    developer.setLastName(lastName);
    developer.setSkills(skills);
    developer.setSpecialty(speciality);
    return developerService.update(id, developer);
  }

  public Developer getById(Long id) {
    return developerService.getById(id);
  }

  public List<Developer> getAllDevelopers() {
    return developerService.getAll();
  }

  public void deleteDeveloper(Long id) {
    developerService.deleteById(id);
  }
}

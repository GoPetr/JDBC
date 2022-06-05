package controller;

import model.Developer;
import model.Skill;
import model.Specialty;
import repository.DeveloperRepository;
import repository.gson.GsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {
  private DeveloperRepository developerRepository = new GsonDeveloperRepositoryImpl();

  //todo нет связонности таблиц! При создании Девелопера и добавлении
  // скилов и специальности, они создаются без id. И не добавляются в соответсвующие таблицы.

  public Developer createDeveloper(String firstName,
                                   String lastName,
                                   String skill,
                                   String speciality) {
    Developer developer = new Developer();
    developer.setFirstName(firstName);
    developer.setLastName(lastName);
    developer.setSkills(new Skill(skill));
    developer.setSpecialty(new Specialty(speciality));
    return developerRepository.save(developer);
  }

  public Developer updateDeveloper(Long id,
                                   String firstName,
                                   String lastName,
                                   String skill,
                                   String speciality) {
    Developer developer = new Developer();
    developer.setFirstName(firstName);
    developer.setLastName(lastName);
    developer.setSkills(new Skill(skill));
    developer.setSpecialty(new Specialty(speciality));
    return developerRepository.update(id, developer);
  }

  public Developer getById(Long id) {
    return developerRepository.getById(id);
  }

  public List<Developer> getAllDevelopers() {
    return developerRepository.getAll();
  }

  public void deleteDeveloper(Long id) {
    developerRepository.deleteById(id);
  }
}

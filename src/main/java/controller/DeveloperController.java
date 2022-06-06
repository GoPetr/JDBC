package controller;

import model.Developer;
import model.Skill;
import model.Specialty;
import repository.DeveloperRepository;
import repository.SkillRepository;
import repository.SpecialtyRepository;
import repository.gson.GsonDeveloperRepositoryImpl;
import repository.gson.GsonSkillRepositoryImpl;
import repository.gson.GsonSpecialtyRepositoryImpl;

import java.util.List;

public class DeveloperController {
  private DeveloperRepository developerRepository = new GsonDeveloperRepositoryImpl();
  private SkillRepository skillRepository = new GsonSkillRepositoryImpl();
  private SpecialtyRepository specialtyRepository = new GsonSpecialtyRepositoryImpl();

  public Developer createDeveloper(String firstName,
                                   String lastName,
                                   List<Skill> skill,
                                   String speciality) {
    Developer developer = new Developer();
    developer.setFirstName(firstName);
    developer.setLastName(lastName);
    skill.forEach(s -> skillRepository.save(s));
    skill.forEach(developer::setSkills);
    Specialty addSpecialty = specialtyRepository.save(new Specialty(speciality));
    developer.setSpecialty(addSpecialty);
    return developerRepository.save(developer);
  }

  public Developer updateDeveloper(Long id,
                                   String firstName,
                                   String lastName,
                                   List<Skill> skill,
                                   String speciality) {
    Developer developer = new Developer();
    developer.setFirstName(firstName);
    developer.setLastName(lastName);
    //skill.forEach(s -> skillRepository.save(s));
    skill.forEach(developer::setSkills);
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

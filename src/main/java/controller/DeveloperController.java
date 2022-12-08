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
import service.impl.DeveloperServiceImpl;

import java.util.List;

public class DeveloperController {
  public final DeveloperServiceImpl developerService = new DeveloperServiceImpl();


  public Developer createDeveloper(String firstName,
                                   String lastName,
                                   List<Skill> skill,
                                   String speciality) {
    Developer developer = new Developer("Lex", "Luthor", 1L, 1L);

    return developerService.save(developer);
  }

//  public Developer updateDeveloper(Long id,
//                                   String firstName,
//                                   String lastName,
//                                   List<Skill> skill,
//                                   String speciality) {
//    Developer developer = new Developer();
//    developer.setFirstName(firstName);
//    developer.setLastName(lastName);
//    skill.forEach(developer::setSkills);
//    developer.setSpecialty(new Specialty(speciality));
//    return developerRepository.update(id, developer);
//  }
//
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

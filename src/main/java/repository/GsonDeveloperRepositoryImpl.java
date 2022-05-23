package repository;

import model.Developer;
import model.Skill;
import model.Specialty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository, Serializable {
  public static ArrayList<Developer> developerList = new ArrayList<>();
  List<Skill> list = List.of(new Skill("speed"));
  Specialty specialty = new Specialty("programmer");

  @Override
  public Developer save(Developer developer) {
    Developer developer1 = new Developer("Igor", "Menshov", list, specialty);
    developerList.add(developer1);
    return developer1;
  }

  @Override
  public Developer getDeveloper(long id) {
    return null;
  }

  @Override
  public List<Developer> getAllDevelopers() {
    return null;
  }

  @Override
  public void delete(long id) {
  }


  public ArrayList<Developer> getDeveloperList() {
    return developerList;
  }


  public List<Skill> getList() {
    return list;
  }

  public void setList(List<Skill> list) {
    this.list = list;
  }

  public Specialty getSpecialty() {
    return specialty;
  }

  public void setSpecialty(Specialty specialty) {
    this.specialty = specialty;
  }
}

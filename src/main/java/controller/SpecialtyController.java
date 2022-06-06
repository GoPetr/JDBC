package controller;

import model.Specialty;
import repository.SpecialtyRepository;
import repository.gson.GsonSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyController {
  private final SpecialtyRepository specialtyRepository = new GsonSpecialtyRepositoryImpl();

  public Specialty createSpecialty(String name) {
    Specialty specialty = new Specialty();
    specialty.setSpecialty(name);
    return specialtyRepository.save(specialty);
  }

  public Specialty updateSpecialty(Long id, String name) {
    Specialty specialty = new Specialty();
    specialty.setSpecialty(name);
    return specialtyRepository.update(id, specialty);
  }

  public Specialty getById(Long id) {
    return specialtyRepository.getById(id);
  }

  public List<Specialty> getAllSpecialties() {
    return specialtyRepository.getAll();
  }

  public void deleteSpecialty(Long id) {
    specialtyRepository.deleteById(id);
  }
}

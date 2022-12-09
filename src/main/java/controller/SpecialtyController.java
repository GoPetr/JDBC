package controller;

import model.Specialty;
import service.impl.SpecialtyServiceImpl;

import java.util.List;

public class SpecialtyController {
  private final SpecialtyServiceImpl specialtyService = new SpecialtyServiceImpl();

  public Specialty createSpecialty(String title) {
    Specialty specialty = new Specialty();
    specialty.setSpecialty(title);
    return specialtyService.save(specialty);
  }

  public Specialty updateSpecialty(Long id, String name) {
    Specialty specialty = new Specialty();
    specialty.setSpecialty(name);
    return specialtyService.update(id, specialty);
  }

  public Specialty getById(Long id) {
    return specialtyService.getById(id);
  }

  public List<Specialty> getAllSpecialties() {
    return specialtyService.getAll();
  }

  public void deleteSpecialty(Long id) {
    specialtyService.deleteById(id);
  }
}

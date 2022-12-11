package service.impl;

import model.Specialty;
import repository.gson.GsonSpecialtyRepositoryImpl;
import service.SpecialtyService;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyService {
  private final GsonSpecialtyRepositoryImpl specialtyRepository = new GsonSpecialtyRepositoryImpl();

  @Override
  public Specialty save(Specialty specialty) {
    return specialtyRepository.save(specialty);
  }

  @Override
  public Specialty update(Long id, Specialty specialty) {
    return null;
  }

  @Override
  public Specialty getById(Long id) {
    return specialtyRepository.getById(id);
  }

  @Override
  public List<Specialty> getAll() {
    return specialtyRepository.getAll();
  }

  @Override
  public void deleteById(Long id) {
    specialtyRepository.deleteById(id);
  }
}

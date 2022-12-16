package service.impl;

import model.Skill;
import repository.gson.GsonSkillRepositoryImpl;
import service.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {
  private final GsonSkillRepositoryImpl skillRepository = new GsonSkillRepositoryImpl();

  @Override
  public Skill save(Skill skill) {
    return skillRepository.save(skill);
  }

  @Override
  public Skill update(Long id, Skill skill) {
    return skillRepository.update(id, skill);
  }

  @Override
  public Skill getById(Long id) {
    return skillRepository.getById(id);
  }

  @Override
  public List<Skill> getAll() {
    return skillRepository.getAll();
  }

  @Override
  public void deleteById(Long id) {
    skillRepository.deleteById(id);
  }
}

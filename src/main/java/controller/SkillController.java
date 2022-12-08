package controller;

import model.Skill;
import repository.SkillRepository;
import repository.gson.GsonSkillRepositoryImpl;

import java.util.List;

public class SkillController {
  public   SkillRepository skillRepository = new GsonSkillRepositoryImpl();

  public Skill createSkill(String name) {
    Skill skill = new Skill();
    skill.setSkill(name);
    return skillRepository.save(skill);
  }

  public Skill updateSkill(Long id, String name) {
    Skill skill = new Skill();
    skill.setSkill(name);
    return skillRepository.update(id, skill);
  }

  public Skill getById(Long id) {
    return skillRepository.getById(id);
  }

  public List<Skill> getAllSkills() {
    return skillRepository.getAll();
  }

  public void deleteSkill(Long id) {
    skillRepository.deleteById(id);
  }
}

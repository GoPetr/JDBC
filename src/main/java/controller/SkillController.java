package controller;

import model.Skill;
import service.impl.SkillServiceImpl;

import java.util.List;

public class SkillController {
  private final SkillServiceImpl skillService = new SkillServiceImpl();

  public Skill createSkill(String name) {
    Skill skill = new Skill();
    skill.setSkill(name);
    return skillService.save(skill);
  }

  public Skill updateSkill(Long id, String name) {
    Skill skill = new Skill();
    skill.setSkill(name);
    return skillService.update(id, skill);
  }

  public Skill getById(Long id) {
    return skillService.getById(id);
  }

  public List<Skill> getAllSkills() {
    return skillService.getAll();
  }

  public void deleteSkill(Long id) {
    skillService.deleteById(id);
  }
}

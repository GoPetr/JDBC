package model;

import java.io.Serializable;

public class Skill implements Serializable {
  private Long id;
  private String skill;

  public Skill() {
  }

  public Skill(String skill) {
    this.skill = skill;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public String toString() {
    return "Skill{" +
            "id=" + id +
            ", skill='" + skill + '\'' +
            '}';
  }
}


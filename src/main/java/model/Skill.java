package model;

import java.io.Serializable;

public class Skill implements Serializable {
  String skill;

  public Skill(){

  }

  public Skill(String skill) {
    this.skill = skill;
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }
}


package view;

import controller.SkillController;
import model.Skill;

import java.util.Scanner;

public class SkillView {
  private final SkillController skillController = new SkillController();
  private final Scanner scanner = new Scanner(System.in);

  public void createSkill() {
    String name = scanner.nextLine();
    Skill skill = skillController.createSkill(name);
    System.out.println("Create skill: " + skill);
  }

}

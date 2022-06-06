package view;

import controller.SkillController;
import model.Skill;

import java.util.Scanner;

public class SkillView {
  private final SkillController skillController = new SkillController();
  private final Scanner scanner = new Scanner(System.in);

  public void createSkill() {
    System.out.print("Input skill: ");
    String name = scanner.nextLine();
    Skill skill = skillController.createSkill(name);
    System.out.println("Create skill: " + skill);
  }

  public void updateSkill() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    System.out.println("Input skill replace: ");
    String name = scanner.nextLine();
    Skill skill = skillController.updateSkill(id, name);
    System.out.println("Update skill successful. Skill: " + skill);
  }

  public void getById() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    Skill skillById = skillController.getById(id);
    System.out.println("Skill for this id: " + id + " is: " + skillById);
  }

  public void getAllSkills() {
    System.out.println("All list of Skills: " + skillController.getAllSkills());
  }

  public void deleteSkill() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    skillController.deleteSkill(id);
    System.out.println("Delete successful");
  }
}

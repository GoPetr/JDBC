package view;

import controller.DeveloperController;
import model.Developer;
import model.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
  private final DeveloperController developerController = new DeveloperController();
  private final Scanner scanner = new Scanner(System.in);

  public void createDeveloper() {
    System.out.println("Create new developer.");

    System.out.println("Input firstName: ");
    String firstName = scanner.nextLine();

    System.out.println("Input lastName: ");
    String lastName = scanner.nextLine();

    List<Skill> skillList = new ArrayList<>();
    while (true) {
      System.out.println("Input developer skill: ");
      String skill = scanner.nextLine();
     // skillList.add(new Skill(skill));
      System.out.println("Do you want to add a new skill? 'y' or 'n'");
      String value = scanner.nextLine();
      if (value.equals("n")) {
        break;
      }
    }

    System.out.println("Input speciality: ");
    String speciality = scanner.nextLine();

    Developer developer = developerController.createDeveloper(firstName, lastName, skillList, speciality);
    System.out.println("Create developer: " + developer);
  }

  public void updateDeveloper() {
    System.out.println("Update developer.");
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);

    System.out.println("Input developer first name: ");
    String firsName = scanner.nextLine();

    System.out.println("Input developer last name: ");
    String lastName = scanner.nextLine();

    List<Skill> skillList = new ArrayList<>();
    while (true) {
      System.out.println("Input developer skill: ");
      String skill = scanner.nextLine();
    //  skillList.add(new Skill(skill));
      System.out.println("Do you want to add a new skill? 'y' or 'n'");
      String value = scanner.nextLine();
      if (value.equals("n")) {
        break;
      }
    }

    System.out.println("Input developer speciality: ");
    String speciality = scanner.nextLine();

  //  Developer developer = developerController.updateDeveloper(id, firsName, lastName, skillList, speciality);
  //  System.out.println("Update developer successful. Developer: " + developer);
  }

  public void getById() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    Developer developerById = developerController.getById(id);
    System.out.println("Developer for this id: " + id + " is: " + developerById);
  }

  public void getAllDevelopers() {
    System.out.println("All list of Skills: " + developerController.getAllDevelopers());
  }

  public void deleteDeveloper() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    developerController.deleteDeveloper(id);
    System.out.println("Delete successful");
  }
}

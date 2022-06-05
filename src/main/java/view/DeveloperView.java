package view;

import controller.DeveloperController;
import model.Developer;

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

    System.out.println("Input skill: ");
    String skill = scanner.nextLine();

    System.out.println("Input speciality: ");
    String speciality = scanner.nextLine();

    Developer developer = developerController.createDeveloper(firstName, lastName, skill, speciality);
    System.out.println("Create developer: " + developer);
  }

  public void updateDeveloper() {
    System.out.println("Update developer.");
    System.out.println("Input id: ");
    //Here need check create or not id.
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);

    System.out.println("Input developer first name: ");
    String firsName = scanner.nextLine();

    System.out.println("Input developer last name: ");
    String lastName = scanner.nextLine();

    //TODO реализовать работу с листом скиллов.
    System.out.println("Input developer skill: ");
    String skill = scanner.nextLine();

    System.out.println("Input developer speciality: ");
    String speciality = scanner.nextLine();

    Developer developer = developerController.updateDeveloper(id, firsName, lastName, skill, speciality);
    System.out.println("Update developer successful. Developer: " + developer);
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

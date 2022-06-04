package view;

import controller.SpecialtyController;
import model.Specialty;

import java.util.Scanner;

public class SpecialtyView {
  private final SpecialtyController specialtyController = new SpecialtyController();
  private final Scanner scanner = new Scanner(System.in);

  public void createSpecialty() {
    System.out.print("Input specialty: ");
    String name = scanner.nextLine();
    Specialty specialty = specialtyController.createSpecialty(name);
    System.out.println("Create specialty: " + specialty);
  }

  public void updateSpecialty() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    System.out.println("Input specialty replace: ");
    String name = scanner.nextLine();
    Specialty specialty = specialtyController.updateSpecialty(id, name);
    System.out.println("Update specialty successful. Specialty: " + specialty);
  }

  public void getById() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    Specialty specialtyById = specialtyController.getById(id);
    System.out.println("Specialty for this id: " + id + " is: " + specialtyById);
  }

  public void getAllSpecialty() {
    System.out.println("All list of Specialty: " + specialtyController.getAllSpecialties());
  }

  public void deleteSpecialty() {
    System.out.println("Input id: ");
    String index = scanner.nextLine();
    Long id = Long.valueOf(index);
    specialtyController.deleteSpecialty(id);
    System.out.println("Delete successful");
  }
}

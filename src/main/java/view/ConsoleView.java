package view;

import model.Developer;
import repository.GsonDeveloperRepositoryImpl;

import java.util.Scanner;

public class ConsoleView {
  GsonDeveloperRepositoryImpl repository = new GsonDeveloperRepositoryImpl();

  public void run() {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Hello this programme helping CREATE, READ, UPDATE and DELETE list of developers");
    while (true) {
      System.out.println("Please input -help to see a list of commands \nor input quite to exit");
      System.out.print("Input command: ");

      String line = scanner.nextLine();

      if (line.equals("quite")) {
        break;
      }

      if (line.equals("-help")) {
        System.out.println("Command list: -help");
        System.out.println("quite");
        System.out.println("create");
        System.out.println("read");
        System.out.println("update");
        System.out.println("delete");
      }

      if (line.equals("create")) {
        create();
      }
      if (line.equals("read")) {
        read();
      }
    }
  }

  public void create() {
    Developer developer = new Developer();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Create developer. Please enter some field");

    System.out.print("Please enter firstname: ");
    developer.setFirstName(scanner.nextLine());
    System.out.println();

    System.out.print("Please enter lastname: ");
    developer.setLastName(scanner.nextLine());
    System.out.println();

    repository.developerList.add(developer);
  }

  public void read() {
    System.out.println("List of developers: ");
    for (Developer o : repository.getDeveloperList()) {
      System.out.println(o);
    }
  }
}

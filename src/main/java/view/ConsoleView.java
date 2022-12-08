//package view;
//
//import java.util.Scanner;
//
//public class ConsoleView {
//  SkillView skillView = new SkillView();
//  SpecialtyView specialtyView = new SpecialtyView();
//  DeveloperView developerView = new DeveloperView();
//
//  public void run() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Hello this programme helping CREATE, READ, UPDATE and DELETE list of developers");
//    while (true) {
//      System.out.println("Please input -help to see a list of commands \nor input quite to exit");
//      System.out.print("Input command: ");
//
//      String line = scanner.nextLine();
//
//      if (line.equals("quite")) {
//        break;
//      }
//
//      if (line.equals("-help")) {
//        help();
//      }
//
//
//      // Блок кода skill
//      if (line.equals("crskill")) {
//        skillView.createSkill();
//      }
//      if (line.equals("updskill")) {
//        skillView.updateSkill();
//      }
//      if (line.equals("idskill")) {
//        skillView.getById();
//      }
//      if (line.equals("allskill")) {
//        skillView.getAllSkills();
//      }
//      if (line.equals("delskill")) {
//        skillView.deleteSkill();
//      }
//
//      //Блок кода specialties
//      if (line.equals("crspec")) {
//        specialtyView.createSpecialty();
//      }
//      if (line.equals("updspec")) {
//        specialtyView.updateSpecialty();
//      }
//      if (line.equals("idspec")) {
//        specialtyView.getById();
//      }
//      if (line.equals("allspec")) {
//        specialtyView.getAllSpecialty();
//      }
//      if (line.equals("delspec")) {
//        specialtyView.deleteSpecialty();
//      }
//
//      //Блок кода developer
//      if (line.equals("crdev")) {
//        developerView.createDeveloper();
//      }
//      if (line.equals("upddev")) {
//        developerView.updateDeveloper();
//      }
//      if (line.equals("iddev")) {
//        developerView.getById();
//      }
//      if (line.equals("alldev")) {
//        developerView.getAllDevelopers();
//      }
//      if (line.equals("deldev")) {
//        developerView.deleteDeveloper();
//      }
//    }
//  }
//
//  public void help() {
//    System.out.println("Command list: -help");
//    System.out.println("List command for Developer:");
//    System.out.print("crdev, upddev, iddev, alldev, deldev");
//    System.out.println();
//    System.out.println("List command for Skill:");
//    System.out.print("crskill, updskill, idskill, allskill, delskill");
//    System.out.println();
//    System.out.println("List command for Specialties:");
//    System.out.print("crspec, updspec, idspec, allspec, delspec");
//    System.out.println();
//
//  }
//}

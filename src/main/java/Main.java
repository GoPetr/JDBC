import controller.DeveloperController;
import controller.SpecialtyController;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    DeveloperController developerController = new DeveloperController();
    SpecialtyController specialtyController = new SpecialtyController();
//    List<Developer> allDevelopers = developerController.getAllDevelopers();
//     System.out.println(allDevelopers);
//    List<Specialty> allSpecialties = specialtyController.getAllSpecialties();
//    System.out.println(allSpecialties);

//    System.out.println(specialtyController.getById(1L));

//    ConsoleView consoleView = new ConsoleView();
//    consoleView.run();


    //Проблемы:
    //1. При удалении не последнего id образуется дыра.
    // И возможно нужно что то придумать, при добавлении элемента эта дыра должна быть заполнена.
  }


}

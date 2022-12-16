import controller.DeveloperController;
import controller.SkillController;
import controller.SpecialtyController;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    DeveloperController developerController = new DeveloperController();
    SpecialtyController specialtyController = new SpecialtyController();
    SkillController skillController = new SkillController();


//    System.out.println(skillController.getAllSkills());
//    ConsoleView consoleView = new ConsoleView();
//    consoleView.run();

  }


}

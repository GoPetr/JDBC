import controller.DeveloperController;
import controller.SkillController;
import controller.SpecialtyController;
import model.Skill;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws SQLException {
    DeveloperController developerController = new DeveloperController();
    SpecialtyController specialtyController = new SpecialtyController();
    SkillController skillController = new SkillController();

    Skill skill = new Skill();
    Skill skill1 = new Skill();
    skill.setSkill("jr5445ii");
    skill1.setSkill("r22445m");
    ArrayList<Skill> list = new ArrayList<>();
    list.add(skill);
    list.add(skill1);


    System.out.println(developerController.createDeveloper(
            "Alexiy",
            "Mizolinov",
            list,
            "Massage"
            ));

//    ConsoleView consoleView = new ConsoleView();
//    consoleView.run();

  }


}

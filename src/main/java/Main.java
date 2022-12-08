import controller.DeveloperController;
import model.Developer;
import util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {
   public static void main(String[] args) throws SQLException {
     DeveloperController developerController = new DeveloperController();
//     List<Developer> allDevelopers = developerController.getAllDevelopers();
//     System.out.println(allDevelopers);

    //  developerController.createDeveloper("sdf", "dgt", new LinkedList<>(), "sddgf");
     System.out.println(developerController.getById(10L));


//    ConsoleView consoleView = new ConsoleView();
//    consoleView.run();


    //Проблемы:
    //1. При удалении не последнего id образуется дыра.
    // И возможно нужно что то придумать, при добавлении элемента эта дыра должна быть заполнена.
  }


}

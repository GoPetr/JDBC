import util.PropertiesUtil;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
  private static final String USERNAME_KEY = "db.username";
  private static final String PASSWORD_KEY = "db.password";
  private static final String URL_KEY = "db.url";

  public static void main(String[] args) throws SQLException {


    try (Connection connection = DriverManager.getConnection(
            PropertiesUtil.get(URL_KEY),
            PropertiesUtil.get(USERNAME_KEY),
            PropertiesUtil.get(PASSWORD_KEY))) {
      System.out.println(connection.getTransactionIsolation());


    }

//    ConsoleView consoleView = new ConsoleView();
//    consoleView.run();


    //Проблемы:
    //1. При удалении не последнего id образуется дыра.
    // И возможно нужно что то придумать, при добавлении элемента эта дыра должна быть заполнена.
  }

}

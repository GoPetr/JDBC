package controller;

import com.google.gson.GsonBuilder;
import model.Developer;

import java.io.*;

public class JSONtoFileRepositoryImpl {

  File file = new File("C:/Users/GoPetr/Documents/Java Projects/CRUD_Project/src/main/resources/developers.json/");

  //По мне это выглядит ужасно. Как сдлеать так, что бы при добавлении не обновлялся файл записи.
  Writer output;

  {
    try {
      output = new BufferedWriter(new FileWriter(file));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  public void save(Developer developer) {
    String jsonDeveloperFormat = new GsonBuilder().setPrettyPrinting().create().toJson(developer);
    // String jsonDeveloperFormat = new Gson().toJson(developer);
    try {
      output.write(jsonDeveloperFormat);
      output.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  //create  for yourself. Get the implementation of the logic in the repository package.
  public void get() {

  }

  public void getAll() {

  }

  public void delete() {

  }
}

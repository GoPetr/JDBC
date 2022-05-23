package controller;

import model.Developer;

import java.io.*;

public class FileRepositoryImpl {
  String home = "C:/Users/GoPetr/Documents/Java Projects/CRUD_Project/src/main/resources/developers.json";

  public void save() {
    try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(home))) {

      Developer developer1 = new Developer("Igor", "Menshov");

      System.out.println(developer1);
      oss.writeObject(developer1);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void get() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("developers.json"))) {
      Developer developer = (Developer) ois.readObject();
      System.out.println(developer);

    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

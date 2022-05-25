package repository;

import com.google.gson.Gson;
import model.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository, Serializable {
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

  public ArrayList<Developer> developerList = new ArrayList<>();

  @Override
  public void save(Developer developer) {
    developerList.add(developer);
    serializeDeveloper(developer);

  }

  @Override
  public Developer getDeveloper(long id) {
    return null;
  }

  @Override
  public List<Developer> getAllDevelopers() {
    return developerList;
  }

  @Override
  public void delete(long id) {
  }

  public void serializeDeveloper(Developer developer) {
    String jsonDeveloperFormat = new Gson().toJson(developer);

    try {
      output.write(jsonDeveloperFormat);
      output.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  public ArrayList<Developer> getDeveloperList() {
    return developerList;
  }
}

package repository.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Developer;
import model.Skill;
import model.Status;
import repository.DeveloperRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
  private final String FILE_PATH = "C:/Users/GoPetr/Documents/Java Projects/CRUD_Project/src/main/resources/developers.json/";
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  private List<Developer> readDevelopersFromFile() {
    Type targetClassType = new TypeToken<ArrayList<Developer>>() {
    }.getType();
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      ArrayList<Developer> list = gson.fromJson(br, targetClassType);
      System.out.println("Read from Developers File: ");
      if (Objects.nonNull(list)) {
        list.forEach(System.out::println);
      } else {
        System.out.println("File is empty");
      }
      return list;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private void writeDevelopersToFile(List<Developer> developers) {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
      String s = gson.toJson(developers);
      bw.write(s);
      bw.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Long generateId(List<Developer> developers) {
    if (developers != null && !developers.isEmpty()) {
      Developer developerWithMaxId = developers.stream().max(Comparator.comparing(Developer::getId)).get();
      return developerWithMaxId.getId() + 1;
    } else {
      return 1L;
    }
  }

  @Override
  public Developer save(Developer developer) {
    List<Developer> developers = readDevelopersFromFile();
    if (developers == null) {
      developers = new ArrayList<>();
    }
    developer.setId(generateId(developers));
    developers.add(developer);
    writeDevelopersToFile(developers);
    return developer;
  }

  @Override
  public Developer update(Long id, Developer developer) {
    List<Developer> developers = readDevelopersFromFile();
    developers.forEach(s -> {
      if (id.equals(s.getId())) {
        s.setFirstName(developer.getFirstName());
        s.setLastName(developer.getLastName());
        List<Skill> skills = developer.getSkills();
        s.getSkills().clear();
        skills.forEach(s::setSkills);
        s.setSpecialty(developer.getSpecialty());
      } else System.out.println("This id incorrect");
    });
    writeDevelopersToFile(developers);
    Developer retDeveloper = getById(id);
    return retDeveloper;
  }

  @Override
  public Developer getById(Long id) {
    return readDevelopersFromFile().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public List<Developer> getAll() {
    return readDevelopersFromFile();
  }

  @Override
  public void deleteById(Long id) {
    List<Developer> developers = readDevelopersFromFile();
    developers.forEach(s -> {
      if (s.getId().equals(id)) {
        s.setStatus(Status.DELETE);
      }
    });
    writeDevelopersToFile(developers);
  }

  @Override
  public String toString() {
    return "GsonDeveloperRepositoryImpl{" +
            "FILE_PATH='" + FILE_PATH + '\'' +
            ", gson=" + gson +
            '}';
  }
}


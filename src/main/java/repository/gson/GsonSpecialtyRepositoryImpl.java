package repository.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Specialty;
import repository.SpecialtyRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {
  private final String FILE_PATH = "C:/Users/GoPetr/Documents/Java Projects/CRUD_Project/src/main/resources/specialties.json/";
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  private List<Specialty> readSpecialtyFromFile() {
    Type targetClassType = new TypeToken<ArrayList<Specialty>>() {
    }.getType();
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      ArrayList<Specialty> list = gson.fromJson(br, targetClassType);
      return list;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private void writeSpecialtyToFile(List<Specialty> specialties) {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
      String s = gson.toJson(specialties);
      bw.write(s);
      bw.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Long generateId(List<Specialty> specialties) {
    if (specialties != null && !specialties.isEmpty()) {
      Specialty specialtiesWithMaxId = specialties.stream().max(Comparator.comparing(Specialty::getId)).orElse(null);
      return specialtiesWithMaxId.getId() + 1;
    } else {
      return 1L;
    }
  }

  @Override
  public Specialty save(Specialty specialty) {
    List<Specialty> specialties = readSpecialtyFromFile();
    if (specialties == null) {
      specialties = new ArrayList<>();
    }
    specialty.setId(generateId(specialties));
    specialties.add(specialty);
    writeSpecialtyToFile(specialties);
    return specialty;
  }

  @Override
  public Specialty update(Long id, Specialty specialty) {
    List<Specialty> specialties = readSpecialtyFromFile();
    specialties.forEach(s -> {
      if (id.equals(s.getId())) {
        s.setSpecialty(specialty.getSpecialty());
      } else System.out.println("This id incorrect");
    });
    writeSpecialtyToFile(specialties);
    Specialty retSpecialty = getById(id);
    return retSpecialty;
  }

  @Override
  public Specialty getById(Long id) {
    return readSpecialtyFromFile().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);

  }

  @Override
  public List<Specialty> getAll() {
    return readSpecialtyFromFile();
  }

  @Override
  public void deleteById(Long id) {
    List<Specialty> specialties = readSpecialtyFromFile();
    specialties.removeIf(s -> s.getId().equals(id));
    writeSpecialtyToFile(specialties);
  }
}

package repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Skill;
import repository.SkillRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GsonSkillRepositoryImpl implements SkillRepository {
  private final String FILE_PATH = "C:/Users/GoPetr/Documents/Java Projects/CRUD_Project/src/main/resources/skills.json/";
  private final Gson gson = new Gson();

  private List<Skill> readSkillsFromFile() {
    Type targetClassType = new TypeToken<ArrayList<Skill>>() {
    }.getType();
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      ArrayList<Skill> list = gson.fromJson(br, targetClassType);
      System.out.println("Read from Skill File: ");
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

  private void writeSkillsToFile(List<Skill> skills) {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
      String s = gson.toJson(skills);
      bw.write(s);
      bw.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Long generateId(List<Skill> skills) {
    //Skill skillWithMaxId = skills.stream().max(Comparator.comparing(Skill::getId)).orElse(null); //Как работать с null? Эта конструкция не работает!
    //  if(skills.isEmpty()) почему эта конструкция не работает?
    if (skills != null && !skills.isEmpty()) {
      // Как мне создать стрим, что бы записать в пустой лист значение?
      Skill skillWithMaxId = skills.stream().max(Comparator.comparing(Skill::getId)).get();
      return skillWithMaxId.getId() + 1;
    } else {
      return 1L;
    }
  }

  @Override
  public Skill save(Skill skill) {
    List<Skill> skills = readSkillsFromFile();
    if (skills == null) {
      skills = new ArrayList<>();
    }
    skill.setId(generateId(skills));
    skills.add(skill);
    writeSkillsToFile(skills);
    return skill;
  }

  @Override
  public Skill update(Long id, Skill skill) {
    List<Skill> skills = readSkillsFromFile();
    skills.forEach(s -> {
      if (id.equals(s.getId())) {
        s.setSkill(skill.getSkill());
      } else System.out.println("This id incorrect");
    });
    writeSkillsToFile(skills);
    Skill retSkill = getById(id);
    return retSkill;
  }

  @Override
  public Skill getById(Long id) {
    return readSkillsFromFile().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public List<Skill> getAll() {
    return readSkillsFromFile();
  }

  @Override
  public void deleteById(Long id) {
    List<Skill> skills = readSkillsFromFile();
    skills.removeIf(s -> s.getId().equals(id));
    writeSkillsToFile(skills);
  }

  @Override
  public String toString() {
    return "GsonSkillRepositoryImpl{" + "FILE_PATH='" + FILE_PATH + '\'' + ", gson=" + gson + '}';
  }
}

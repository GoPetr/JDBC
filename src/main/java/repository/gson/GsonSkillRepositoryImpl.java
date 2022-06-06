package repository.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Skill;
import repository.SkillRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GsonSkillRepositoryImpl implements SkillRepository {
  private final String FILE_PATH = "C:/Users/GoPetr/Documents/Java Projects/CRUD_Project/src/main/resources/skills.json/";
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  private List<Skill> readSkillsFromFile() {
    Type targetClassType = new TypeToken<ArrayList<Skill>>() {
    }.getType();
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      ArrayList<Skill> list = gson.fromJson(br, targetClassType);
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
    if (skills != null && !skills.isEmpty()) {
      Skill skillWithMaxId = skills.stream().max(Comparator.comparing(Skill::getId)).orElse(null);
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
}

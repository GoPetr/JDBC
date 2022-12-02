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
import java.util.Objects;

public class GsonSkillRepositoryImpl implements SkillRepository {
   @Override
  public Skill save(Skill skill) {
   return null;
  }

  @Override
  public Skill update(Long id, Skill skill) {
    return null;
  }

  @Override
  public Skill getById(Long id) {
    return null;
  }

  @Override
  public List<Skill> getAll() {
    return null;
  }

  @Override
  public void deleteById(Long id) {
  }
}

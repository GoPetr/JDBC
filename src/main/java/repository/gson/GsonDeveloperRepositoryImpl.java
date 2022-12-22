package repository.gson;

import model.Developer;
import model.Skill;
import model.Specialty;
import model.Status;
import repository.DeveloperRepository;
import util.StartConnection;

import java.sql.*;
import java.util.*;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
  public static final String FIND_ALL_SQL = """
          SELECT developer.id,
           first_name,
           last_name,
           skill,
           specialty,
           status
           FROM developer
           LEFT JOIN dev_skills ds on developer.id = ds.id_dev
           LEFT  JOIN skill s on s.id = ds.id_skills
           LEFT  JOIN developers.specialty sp ON developer.id_specialty = sp.id
           LEFT JOIN developers.statuses st ON developer.id_status = st.id
          """;

  public static final String FIND_BY_ID_SQL = """
          SELECT developer.id,
              first_name,
              last_name,
              skill,
              specialty,
              status
              FROM developer
              LEFT JOIN dev_skills ds on developer.id = ds.id_dev
              LEFT  JOIN skill s on s.id = ds.id_skills
              LEFT  JOIN developers.specialty sp ON developer.id_specialty = sp.id
              LEFT JOIN developers.statuses st ON developer.id_status = st.id
              WHERE developer.id = ?
             """;

  public static final String SAVE_SQL = """
          INSERT INTO developer (first_name, last_name, id_specialty, id_status)
          VALUES (?,?,?,?);
          """;

  public static final String UPDATE_SQL = """
                    
          """;

  public static final String DELETE_SQL = """
          DELETE FROM developer
          WHERE id = ?
          """;

  @Override
  public List<Developer> getAll() {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      Set<Developer> developerSet = new HashSet<>();
      Developer developer;
      while (resultSet.next()) {
        developer = new Developer();
        developer.setId(resultSet.getLong("id"));
        developer.setFirstName(resultSet.getString("first_name"));
        developer.setLastName(resultSet.getString("last_name"));
        addDevSkill(developer, developerSet, resultSet.getString("skill"));
        developer.setSpecialty(resultSet.getString("specialty"));
        developer.setStatus(Status.valueOf(resultSet.getString("status")));
        developerSet.add(developer);
      }
      List<Developer> developerList;
      developerList = developerSet.stream().toList();
      return developerList;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Developer getById(Long id) {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      Set<Developer> developerSet = new HashSet<>();
      Developer developer = new Developer();
      while (resultSet.next()) {
        developer.setId(resultSet.getLong("id"));
        developer.setFirstName(resultSet.getString("first_name"));
        developer.setLastName(resultSet.getString("last_name"));
        addDevSkill(developer, developerSet, resultSet.getString("skill"));
        developer.setSpecialty(resultSet.getString("specialty"));
        developer.setStatus(Status.valueOf(resultSet.getString("status")));
        developerSet.add(developer);
      }
      return developer;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Developer save(Developer developer) {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
      preparedStatement.setString(1, developer.getFirstName());
      preparedStatement.setString(2, developer.getLastName());

      GsonSpecialtyRepositoryImpl specialtyRepository = new GsonSpecialtyRepositoryImpl();
      Specialty specialty = new Specialty();  // todo how make it with Stream or Lambda
      specialty.setSpecialty(developer.getSpecialty());
      specialty = specialtyRepository.save(specialty);

      preparedStatement.setLong(3, specialty.getId());
      preparedStatement.setLong(4, 1L);

      GsonSkillRepositoryImpl skillRepository = new GsonSkillRepositoryImpl();
      for (Skill skill : developer.getSkills()) {
        skillRepository.save(skill);
      }
      preparedStatement.executeUpdate();

      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if (generatedKeys.next()) {
        developer.setId(generatedKeys.getLong(1));
      }

      addIdDevSkillsTable(developer);

      return developer;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Developer update(Long id, Developer developer) {
    return null;
  }

  @Override
  public void deleteById(Long id) {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private void addDevSkill(Developer developer, Set<Developer> developerSet, String skill) {
    Skill newSkill = new Skill();

    boolean devFoundFlag = false;
    for (Developer developerCount : developerSet) {
      if (developer.getId().equals(developerCount.getId())) {
        devFoundFlag = true;
        newSkill.setSkill(skill);
        developerCount.getSkills().add(newSkill);
      }
    }

    if (!devFoundFlag) {
      newSkill.setSkill(skill);
      developer.setSkills(new ArrayList<>(Arrays.asList(newSkill)));
    }
  }

  private void addIdDevSkillsTable(Developer developer) {
    String ADD_ID_DEV_SKILLS_SQL = """
            INSERT INTO dev_skills (id_dev, id_skills)
            VALUES (?,?)
            """;

    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(ADD_ID_DEV_SKILLS_SQL)) {
      for (Skill skill : developer.getSkills()) {
        preparedStatement.setLong(1, developer.getId());
        preparedStatement.setLong(2, skill.getId());
        preparedStatement.executeUpdate();
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}


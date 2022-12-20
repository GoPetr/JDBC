package repository.gson;

import model.Developer;
import model.Skill;
import model.Status;
import repository.DeveloperRepository;
import util.StartConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
          SELECT first_name,
          last_name,
           id_skill,
          id_specialty,
          status
          FROM developer WHERE id = ?
          """;

  public static final String SAVE_SQL = """
          INSERT INTO developer (first_name, last_name, id_skill, id_specialty, status)
          VALUES (?,?,?,?,?);
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
      Developer developer = new Developer();
      if (resultSet.next()) {
        developer.setFirstName(resultSet.getString("first_name"));
        developer.setLastName(resultSet.getString("last_name"));
        //  developer.setSkills(resultSet.getLong("id_skill"));
        //  developer.setSpecialty(resultSet.getLong("id_specialty"));
      }

      return developer;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Developer save(Developer developer) {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
      preparedStatement.setString(1, developer.getFirstName());
      preparedStatement.setString(2, developer.getLastName());
      //  preparedStatement.setLong(3, developer.getSkills());
      //  preparedStatement.setLong(4, developer.getSpecialty());
      preparedStatement.setInt(5, 3);
      preparedStatement.executeUpdate();

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

  private List<Skill> createSkills(Set<Developer> developerSet, String skill) {
    List<Skill> skillList = new ArrayList<>();
    Skill stringToSkill = new Skill();

    for (Developer developer : developerSet) {
      if (developer.getSkills().isEmpty()) {

      }
    }
    stringToSkill.setSkill(skill);
    skillList.add(stringToSkill);
    return skillList;
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
}



package repository.gson;

import model.Developer;
import repository.DeveloperRepository;
import util.StartConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
  public static final String FIND_ALL_SQL = """
          SELECT first_name,
           last_name,
           id_skill,
           id_specialty,
           status
           FROM developer
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
      Developer developer;
      List<Developer> list = new ArrayList<>();
      while (resultSet.next()) {
        developer = new Developer(resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getLong("id_skill"),
                resultSet.getLong("id_specialty"));
        list.add(developer);
      }
      return list;

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
        developer.setSkills(resultSet.getLong("id_skill"));
        developer.setSpecialty(resultSet.getLong("id_specialty"));
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
      preparedStatement.setLong(3, developer.getSkills());
      preparedStatement.setLong(4, developer.getSpecialty());
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
}



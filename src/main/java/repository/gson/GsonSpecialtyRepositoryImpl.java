package repository.gson;

import model.Specialty;
import repository.SpecialtyRepository;
import util.StartConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {
  public static final String FIND_ALL_SQL = """
                  SELECT id, specialty
                  FROM specialty;
          """;

  public static final String FIND_BY_ID_SQL = """
                  SELECT id, specialty
                  FROM specialty
                  WHERE id = ?;
          """;


  @Override
  public List<Specialty> getAll() {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      List<Specialty> list = new ArrayList<>();
      Specialty specialty;
      while (resultSet.next()) {
        specialty = new Specialty();
        specialty.setSpecialty(resultSet.getString("specialty"));
        list.add(specialty);
      }
      return list;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Specialty getById(Long id) {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      Specialty specialty = new Specialty();
      if (resultSet.next()) {
        specialty.setSpecialty(resultSet.getString("specialty"));
      }

      return specialty;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Specialty save(Specialty specialty) {
    return null;
  }

  @Override
  public Specialty update(Long id, Specialty specialty) {
    return null;
  }

  @Override
  public void deleteById(Long id) {
  }
}

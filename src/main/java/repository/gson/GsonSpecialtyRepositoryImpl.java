package repository.gson;

import model.Specialty;
import repository.SpecialtyRepository;
import util.StartConnection;

import java.sql.*;
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

  public static final String SAVE_SQL = """
                        INSERT INTO specialty (specialty)
                        VALUES (?);
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
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
      preparedStatement.setString(1, specialty.getSpecialty());
      preparedStatement.executeUpdate();

      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if(generatedKeys.next()){
      //  specialty.setId(generatedKeys.getLong("id")); todo почему не работает.
        specialty.setId(generatedKeys.getLong(1));
        System.out.println(specialty);
      }

      return specialty;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Specialty update(Long id, Specialty specialty) {
    return null;
  }

  @Override
  public void deleteById(Long id) {
  }
}

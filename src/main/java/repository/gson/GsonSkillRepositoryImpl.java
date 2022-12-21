package repository.gson;

import model.Skill;
import repository.SkillRepository;
import util.StartConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GsonSkillRepositoryImpl implements SkillRepository {
  public static final String FIND_ALL_SQL = """
                  SELECT id, skill
                  FROM skill;
          """;

  public static final String FIND_BY_ID_SQL = """
                  SELECT id, skill
                  FROM skill
                  WHERE id = ?;
          """;

  public static final String SAVE_SQL = """
                  INSERT INTO skill (skill)
                  VALUES (?);
          """;

  public static final String UPDATE_SQL = """
                  UPDATE skill
                  SET skill = ?
                  WHERE id = ?
          """;

  public static final String DELETE_SQL = """
                  DELETE FROM skill
                  WHERE id = ?;
          """;


  @Override
  public List<Skill> getAll() {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      List<Skill> list = new ArrayList<>();
      Skill skill;
      while (resultSet.next()) {
        skill = new Skill();
        skill.setId(resultSet.getLong("id"));
        skill.setSkill(resultSet.getString("skill"));
        list.add(skill);
      }

      return list;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Skill getById(Long id) {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      Skill skill = new Skill();
      if (resultSet.next()) {
        skill.setId(resultSet.getLong("id"));
        skill.setSkill(resultSet.getString("skill"));
      }

      return skill;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Skill save(Skill skill) {
    if (checkSkills(skill)) {
      try (Connection connection = StartConnection.startConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, skill.getSkill());
        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
          skill.setId(generatedKeys.getLong(1));
        }
        return skill;

      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("THIS SKILL EXISTS");
    return null;

  }

  @Override
  public Skill update(Long id, Skill skill) {
    try (Connection connection = StartConnection.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
      preparedStatement.setString(1, skill.getSkill());
      preparedStatement.setLong(2, id);

      if (preparedStatement.executeUpdate() == 0) {
        System.out.println("WARNING: Nothing was updated");
        return null;
      }

      skill.setId(id);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return skill;
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

  public boolean checkSkills(Skill skill) {
    List<Skill> skillList = getAll();

    Skill stream = skillList.stream().
            filter(x -> skill.getSkill().equals(x.getSkill())).
            findAny().
            orElse(null);

    if (stream == null) {
      return true;
    }
    return false;
  }
}

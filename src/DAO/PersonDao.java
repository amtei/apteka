package DAO;

import DaoException.DaoException;
import Util.ConnectionManager;
import entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDao {
    private static final PersonDao INSTANCE = new PersonDao();


    private  static final String SAVE_SQL = """
           INSERT INTO  person (name,lastname,wallet)
           VALUES (?,?,?)
            """;

    private PersonDao(){

    }

  public Person save(Person person) {
      try (
              var connection = ConnectionManager.get();
              var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
          preparedStatement.setString(1, person.getName());
          preparedStatement.setString(2, person.getLastname());
          preparedStatement.setInt(3, person.getWallet());

          preparedStatement.executeUpdate();

          var generatedKeys = preparedStatement.getGeneratedKeys();
          if (generatedKeys.next()) {
              person.setId(generatedKeys.getInt("id"));
          }
          return person;


      } catch (Exception e) {
          throw new DaoException(e);
      }




  }
    public static PersonDao getInstance(){
        return INSTANCE;
    }

}


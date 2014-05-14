package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
  final String databaseURL = "jdbc:mysql://localhost/";
  final static String user = "username";
  final static String password = "password";

  Connection connection;
  PreparedStatement preparedStatement;
  ResultSet rs;

  public App() throws Exception{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
  }
  
  public void insertData() {
    try {
      connection = DriverManager.getConnection(databaseURL, user, password);
      preparedStatement = connection.prepareStatement("INSERT INTO Shippable.test (city, state) VALUES (?, ?);");
      preparedStatement.setString(1, "Seattle");
      preparedStatement.setString(2, "WA");
      preparedStatement.executeUpdate();
    } catch (java.sql.SQLException ex) {
    } finally {
      try {
        preparedStatement.close();
      } catch (java.sql.SQLException ex) {
        preparedStatement = null;
      }
      try {
        connection.close();
      } catch (java.sql.SQLException ex) {
        connection = null;
      }
    }
  }
  public String getData() {
    String toReturn = "";
    try {
      connection = DriverManager.getConnection(databaseURL, user, password);
      preparedStatement = connection.prepareStatement("SELECT * FROM Shippable.test");
      rs = preparedStatement.executeQuery();
      if (rs.next()) {
        toReturn = rs.getString("city") + ", " + rs.getString("state");
      }
    } catch (java.sql.SQLException ex) {
    } finally {
      try {
        preparedStatement.close();
      } catch (java.sql.SQLException ex) {
        preparedStatement = null;
      }
      try {
        connection.close();
      } catch (java.sql.SQLException ex) {
        connection = null;
      }
      return toReturn;
    }
  }
}

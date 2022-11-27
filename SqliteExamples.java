package HomeWork7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SqliteExamples {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:HomeWork7.db");
            Statement statement = connection.createStatement()) {

                Object ResultSet;
                statement.executeUpdate("Введите название города = " ");

                        ResultSet resultSet = statement.executeQuery("select * from period");

                while (resultSet.next()) {
                System.out.print(resultSet.getString(" "));
                System.out.print(" ");
                System.out.print(resultSet.getInt(" "));
                System.out.println();
            }
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into api_key () values (?, ?)");
                connection.setAutoCommit(false);{
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }
        }
    }
    }
    }

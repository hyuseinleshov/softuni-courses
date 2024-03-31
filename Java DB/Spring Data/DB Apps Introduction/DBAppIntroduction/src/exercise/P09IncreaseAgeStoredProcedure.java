package exercise;

import java.sql.*;
import java.util.Scanner;

public class P09IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();

        int id = Integer.parseInt(scanner.nextLine());

        CallableStatement callableStatement = connection.prepareCall("{call usp_get_older(?)}");
        callableStatement.setInt(1, id);

        callableStatement.executeUpdate();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT name, age FROM minions WHERE id = " + id);

        while (rs.next()) {
            System.out.printf("%s %d\n", rs.getString("name"), rs.getInt("age"));
        }

    }
}

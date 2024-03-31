package exercise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();

        String country = scanner.nextLine();

        Statement statement = connection.createStatement();
        String sql = "UPDATE towns SET name = UPPER(name) WHERE country = '" + country + "'";
        int rowsAffected = statement.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println(rowsAffected + " town names were affected.");

            ResultSet rs = statement.executeQuery("SELECT name FROM towns WHERE country = '" + country + "'");

            List<String> towns = new ArrayList<>();

            while (rs.next()) {
                towns.add(rs.getString("name"));
            }

            System.out.println(towns);
        } else {
            System.out.println("No town names were affected.");
        }

    }
}

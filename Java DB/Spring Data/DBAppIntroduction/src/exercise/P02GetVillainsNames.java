package exercise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P02GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();

        String sql = "SELECT v.name, COUNT(mv.villain_id) AS count\n" +
                "FROM villains v\n" +
                "JOIN minions_villains mv ON v.id = mv.villain_id\n" +
                "GROUP BY v.id\n" +
                "HAVING count > 15 ORDER BY count DESC";

        ResultSet rs = connection.createStatement().executeQuery(sql);

        while (rs.next()) {
            System.out.printf("%s %d\n", rs.getString("name"), rs.getInt("count"));
        }

        dbConnector.closeConnection();

    }
}
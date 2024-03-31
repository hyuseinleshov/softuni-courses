package exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P03GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();

        String sql = "SELECT m.name, m.age\n" +
                "FROM minions m\n" +
                "JOIN minions_villains mv ON m.id = mv.minion_id\n" +
                "JOIN villains v ON mv.villain_id = v.id\n" +
                "WHERE v.id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        int id = Integer.parseInt(scanner.nextLine());

        stmt.setInt(1, id);
        ResultSet peopleRs = stmt.executeQuery();

        if (!peopleRs.next()) {
            System.out.printf("No villain with ID %d exists in the database.\n", id);
        } else {
            ResultSet townRs = connection.createStatement().executeQuery("SELECT name FROM villains WHERE id = " + id);
            townRs.next();
            System.out.println("Villain: " + townRs.getString("name"));

            int count = 1;
            while (peopleRs.next()) {
                System.out.printf("%d. %s %d\n", count, peopleRs.getString("name"), peopleRs.getInt("age"));
                count++;
            }
        }

    }
}

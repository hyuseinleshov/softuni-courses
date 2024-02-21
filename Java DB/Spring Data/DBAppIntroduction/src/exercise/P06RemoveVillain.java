package exercise;

import java.sql.*;
import java.util.Scanner;

public class P06RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();

        int id = Integer.parseInt(scanner.nextLine());

        Statement statement = connection.createStatement();
        String deleteChildRows = "DELETE FROM minions_villains WHERE villain_id = " + id;
        int rowsAffected = statement.executeUpdate(deleteChildRows);

        if (rowsAffected > 0) {
            ResultSet rs = statement.executeQuery("SELECT name FROM villains WHERE id = " + id);
            rs.next();
            String name = rs.getString("name");

            String deleteVillain = "DELETE FROM villains WHERE id = " + id;
            statement.executeUpdate(deleteVillain);

            System.out.println(name + " was deleted");
            System.out.println(rowsAffected + " minions released");
        } else {
            System.out.println("No such villain was found");
        }

    }
}

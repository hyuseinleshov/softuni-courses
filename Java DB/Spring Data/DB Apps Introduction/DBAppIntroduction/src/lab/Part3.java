package lab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Part3 {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = scanner.nextLine();
        System.out.println();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        PreparedStatement stmt = connection.prepareStatement
                ("SELECT u.first_name, u.last_name, COUNT(*) AS count\n" +
                        "FROM users u JOIN users_games ug ON u.id = ug.user_id\n" +
                        "GROUP BY u.user_name, u.first_name, u.last_name\n" +
                        "HAVING u.user_name = ?");

        String username = scanner.nextLine();
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();


        if (!rs.next()) {
            System.out.println("No such user exists");
        } else {
            int gamesCount = rs.getInt("count");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            System.out.printf("User: %s\n", username);
            System.out.printf("%s %s has played %d games\n", firstName, lastName, gamesCount);
        }

    }

}

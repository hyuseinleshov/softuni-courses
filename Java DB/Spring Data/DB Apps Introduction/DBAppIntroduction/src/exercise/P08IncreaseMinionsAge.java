package exercise;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class P08IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();

        int[] ids = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder queryBuilder = new StringBuilder("UPDATE minions SET name = LOWER(name), age = age + 1 WHERE id IN (");
        for (int i = 0; i < ids.length; i++) {
            queryBuilder.append("?");
            if (i < ids.length - 1) {
                queryBuilder.append(", ");
            }
        }
        queryBuilder.append(")");
        String query = queryBuilder.toString();

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (int i = 0; i < ids.length; i++) {
            preparedStatement.setInt(i + 1, ids[i]);
        }

        preparedStatement.executeUpdate();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT name, age FROM minions");

        while (rs.next()) {
            System.out.printf("%s %d\n", rs.getString("name"), rs.getInt("age"));
        }

    }
}

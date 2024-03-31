package exercise;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P07PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT name FROM minions");

        ArrayDeque<String> deque = new ArrayDeque<>();

        while (resultSet.next()) {
            deque.add(resultSet.getString(1));
        }

        while (!deque.isEmpty()) {
            System.out.println(deque.getFirst());
            System.out.println(deque.getLast());

            deque.removeFirst();
            deque.removeLast();
        }

    }
}

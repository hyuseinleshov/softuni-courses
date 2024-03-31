package exercise;

import java.sql.*;
import java.util.Scanner;

public class P04AddMinion {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DBConnector dbConnector = new DBConnector("minions_db");
        Connection connection = dbConnector.getConnection();

        String[] minionData = scanner.nextLine().split("\\s+");
        String[] villainData = scanner.nextLine().split("\\s+");

        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];

        String villainName = villainData[1];

        int townId = getTownId(connection, minionTown);

        if (townId == -1) {
            townId = insertTown(connection, minionTown);
            System.out.println("Town " + minionTown + " was added to the database.");
        }

        int villainId = getVillainId(connection, villainName);

        if (villainId == -1) {
            villainId = insertVillain(connection, villainName);
            System.out.println("Villain " + villainName + " was added to the database.");
        }

        int minionId = insertMinion(connection, minionName, minionAge, townId);

        setMinionServantOfVillain(connection, minionId, villainId);
        System.out.println("Successfully added " + minionName + " to be minion of " + villainName + ".");

        connection.close();
    }

    private static int getTownId(Connection connection, String townName) throws SQLException {
        String sql = "SELECT id FROM towns WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, townName);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        }
        return -1;
    }

    private static int insertTown(Connection connection, String townName) throws SQLException {
        String sql = "INSERT INTO towns (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, townName);
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        return -1;
    }

    private static int getVillainId(Connection connection, String villainName) throws SQLException {
        String sql = "SELECT id FROM villains WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, villainName);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        }
        return -1;
    }

    private static int insertVillain(Connection connection, String villainName) throws SQLException {
        String sql = "INSERT INTO villains (name, evilness_factor) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, villainName);
            stmt.setString(2, "evil");
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        return -1;
    }

    private static int insertMinion(Connection connection, String minionName, int minionAge, int townId) throws SQLException {
        String sql = "INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, minionName);
            stmt.setInt(2, minionAge);
            stmt.setInt(3, townId);
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        return -1;
    }

    private static void setMinionServantOfVillain(Connection connection, int minionId, int villainId) throws SQLException {
        String sql = "INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, minionId);
            stmt.setInt(2, villainId);
            stmt.executeUpdate();
        }
    }

}

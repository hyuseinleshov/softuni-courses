package exercise;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    private Connection connection;

    public DBConnector(String tableName) throws SQLException {
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("db.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty("user", properties.getProperty("username"));
        properties.setProperty("password", properties.getProperty("password"));

        connection = DriverManager.getConnection(String.format(properties.getProperty("url"), tableName), properties);
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

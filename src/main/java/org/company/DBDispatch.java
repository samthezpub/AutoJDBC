package org.company;

import org.postgresql.core.BaseConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBDispatch {
    private static DBDispatch INSTANCE;

    private Connection connection;

    private String url;
    private String username;
    private String password;

    private DBDispatch() {
        loadConfig();
        connectDatabase();
    }

    public static DBDispatch getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBDispatch();
        }
        return INSTANCE;
    }

    private void loadConfig() {
        Properties properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/main/resources/db.properties");
            properties.load(input);
            input.close();

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connectDatabase() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getDrivers() {
        String sql = "SELECT * FROM drivers";

        ResultSet resultSet;
        try {
            var statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public void createMoneyTop(Driver driver) {
        String sql = "INSERT INTO moneytop (drivername, money) VALUES (?,?)";


        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, driver.getName());
            statement.setDouble(2, driver.getMoney());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMostRichDriver() {
        String sql = "SELECT drivername, money FROM moneytop WHERE money = (SELECT MAX(money) FROM moneytop)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1) + " " + resultSet.getDouble(2); // Индексация начинается с 1
            } else {
                throw new RuntimeException("Результат запроса пуст.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPathPassedRecord(Driver driver) {
        String sql = "INSERT INTO pathpassed (driverName,cargo,money,experience) VALUES (?,?,?,?)";


        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, driver.getName());
            statement.setInt(2, driver.getCargoCount());
            statement.setDouble(3, driver.getMoney());
            statement.setInt(4, driver.getExperience());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}


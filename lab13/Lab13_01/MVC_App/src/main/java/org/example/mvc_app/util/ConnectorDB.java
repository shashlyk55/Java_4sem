package org.example.mvc_app.util;

import org.example.mvc_app.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectorDB {
    public static Connection getConnection() {
        return connection;
    }

    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost/users_db?useSSL=false";
    private static final String user = "root";
    private static final String pass = "123qweasdzxc";
    private final static String SQL_SELECT = "SELECT COUNT(*) as row_count FROM users WHERE login = ? AND hashPassword = ?";
    private final static String SQL_INSERT = "INSERT INTO users values (?, ?)";

    public ConnectorDB() {}
    public void OpenConnection() throws SQLException {
        connection  = DriverManager.getConnection(url, user, pass);
        if(!connection.isClosed()){
            System.out.println("Подключение прошло успешно!");
        }
        else{
            System.out.println("Ошибка подключения!");
        }
    }
    public User GetCurrentUser(String login, String password){
        PreparedStatement statement = ConnectorDB.getConnection().prepareStatement("SELECT * FROM users WHERE username = ?");
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setUsername(resultSet.getString("login"));
            user.setPassword(resultSet.getString("hashPassword"));
        }*/
    }
    public boolean IsUserInDB(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
        preparedStatement.setString(1, String.valueOf(login));
        preparedStatement.setString(2, String.valueOf(password));
        ResultSet res = preparedStatement.executeQuery();
        if(res.next()){
            int rowCount = res.getInt("row_count");
            return rowCount != 0;
        }
        return false;
    }
    public boolean RegisterUser(String login, String hashPassword) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
        preparedStatement.setString(1, String.valueOf(login));
        preparedStatement.setString(2, String.valueOf(hashPassword));
        int res = preparedStatement.executeUpdate();
        return res > 0;
    }
    public void CloseConnection() throws SQLException {
        connection.close();
        System.out.println("Подключение удалено!");
    }
    public void CloseStatement(Statement statement) throws SQLException {
        statement.close();
    }
}

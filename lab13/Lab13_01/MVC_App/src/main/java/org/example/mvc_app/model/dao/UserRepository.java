package org.example.mvc_app.model.dao;

import org.example.mvc_app.model.entity.User;
import org.example.mvc_app.util.ConnectorDB;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            ConnectorDB dbConnector = new ConnectorDB();
            dbConnector.OpenConnection();

            user = dbConnector.

            /*ConnectorDB connectorDB = new ConnectorDB();
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connectorDB.OpenConnection();
            PreparedStatement statement = ConnectorDB.getConnection().prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("login"));
                user.setPassword(resultSet.getString("hashPassword"));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        try {
            ConnectorDB connectorDB = new ConnectorDB();
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connectorDB.OpenConnection();
            PreparedStatement statement = ConnectorDB.getConnection().prepareStatement("INSERT INTO users (login, hashPassword) VALUES (?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

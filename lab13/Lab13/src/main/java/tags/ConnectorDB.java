package tags;

import tags.Game;

import java.sql.*;
import java.util.ArrayList;

public class ConnectorDB{
    public Connection connection;

    public ConnectorDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Java?autoReconnect=true&useSSL=false","root", "123qweasdzxc");
    }
    public boolean findUsers(String name,String password) throws SQLException {
        if (!connection.isClosed()) {
            String request = "SELECT * FROM java.usersandadmins;";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if(resultSet.getString(1).equals(name)){
                    if(resultSet.getString(2).equals(password))
                        return true;
                }
            }
            return false;
        }
        return false;
    }
    public String getStatus(String name,String password) throws SQLException {
        if (!connection.isClosed()) {
            String request = "SELECT * FROM java.usersandadmins;";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if(resultSet.getString(1).equals(name)){
                    if(resultSet.getString(2).equals(password))
                        return resultSet.getString(3);
                }
            }
            return null;
        }
        return null;
    }
    public void createUser(String name,String password, String status) throws SQLException, ClassNotFoundException {
        if (!connection.isClosed()) {
            String request = "INSERT INTO `java`.`usersandadmins`\n" +
                    "(`NameUser`,\n" +
                    "`Password`,\n" +
                    "`Status`)\n" +
                    "VALUES\n" +
                    "(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,status);

            preparedStatement.execute();
        }
    }

    public void createGame(String name, String type) throws SQLException, ClassNotFoundException {
        if (!connection.isClosed()) {
            String request = "INSERT INTO `java`.`games`\n" +
                    "(`NameGames`,\n" +
                    "`TypeGames`)\n" +
                    "VALUES\n" +
                    "(?,\n" +
                    "?);";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,type);

            preparedStatement.execute();
        }
    }

    public void deleteGame() throws SQLException, ClassNotFoundException {
        if (!connection.isClosed()) {
            String request = "TRUNCATE TABLE java.games;";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.execute();
        }
    }

    public ArrayList<Game> getGames() throws SQLException {
        ArrayList<Game> games = new ArrayList<>();

        String request = "SELECT * FROM java.games;";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            games.add(new Game(resultSet.getString(1),resultSet.getString(2)));
        }

        return  games;
    }
}
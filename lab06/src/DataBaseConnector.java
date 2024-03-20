import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;

public class DataBaseConnector implements IQuery,IOpenCloseConnection{
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(DataBaseConnector.class);
    Connection connection;
    String url;
    String user;
    String pass;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    private final static String SQL_SELECT =
            "SELECT * FROM City inner join Citizens on City.city_name = Citizens.city WHERE Citizens.quantity = ?;";
    public DataBaseConnector(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void OpenConnection() throws SQLException {
        connection  = DriverManager.getConnection(url, user, pass);
        if(!connection.isClosed()){
            LOG.info("Подключение прошло успешно!");
            System.out.println("Подключение прошло успешно!");
        }
        else{
            LOG.info("Ошибка подключения!");
            System.out.println("Ошибка подключения!");
        }
    }
    @Override
    public void CloseConnection() throws SQLException {
        connection.close();
        LOG.info("Подключение удалено!");
        System.out.println("Подключение удалено!");
    }
    public void CloseStatement(Statement statement) throws SQLException {
        statement.close();
    }
    @Override
    public void GetPeopleOnCurrentLanguageAndCity(String city_name, String lang) throws SQLException {
        String request = "select * from citizens where citizens.city = ? and citizens.language = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1, String.valueOf(city_name));
        preparedStatement.setString(2, String.valueOf(lang));
        ResultSet res = preparedStatement.executeQuery();
        System.out.println("Жители города " + city_name + " ,говорящие на языке " + lang);
        LOG.info("Жители города " + city_name + " ,говорящие на языке " + lang);

        while(res.next()){
            System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4));
            LOG.info(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4));
        }
    }

    @Override
    public void GetCitiesOnPeopleType(String peopleType) throws SQLException {
        String request = "select city from citizens where people_type = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1, String.valueOf(peopleType));
        ResultSet res = preparedStatement.executeQuery();
        System.out.println("Жители типа " + peopleType + " проживают в городах:");
        LOG.info("Жители типа " + peopleType + " проживают в городах:");

        while(res.next()){
            System.out.println(res.getString(1));
            LOG.info(res.getString(1));
        }
    }

    @Override
    public void GetCityOnPeopleCounty(int quantity) throws SQLException {
        String request = "select * from citizens inner join towns on citizens.city = towns.name where towns.quantity = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1, String.valueOf(quantity));
        ResultSet res = preparedStatement.executeQuery();
        System.out.println("Города с населением " + quantity + " :");
        LOG.info("Города с населением " + quantity + " :");

        while(res.next()){
            System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+
                    " "+res.getString(4)+" "+res.getString(6)+" "+
                    res.getString(7)+" "+res.getString(8));
            LOG.info(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+
                    " "+res.getString(4)+" "+res.getString(6)+" "+
                    res.getString(7)+" "+res.getString(8));
        }
    }

    @Override
    public void GetOldestPeopleType() throws SQLException {
        String request = "select * from towns order by towns.establish_year limit 1";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(request);
        System.out.println("Самый древний город: ");
        LOG.info("Самый древний город: ");

        while(res.next()){
            System.out.println(res.getString(1));
            LOG.info(res.getString(1));
        }
    }
}

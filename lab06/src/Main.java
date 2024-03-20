import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        LOG.info("Starting program_____________________________");
        String url = "jdbc:mysql://localhost/towns";
        String username = "root";
        String password = "123qweasdzxc";
        //java -classpath c:\Java\mysql-connector-java-8.0.11.jar;c:\Java Program
        DataBaseConnector dataBaseConnector = new DataBaseConnector(url,username,password);
        try{

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            dataBaseConnector.OpenConnection();
            dataBaseConnector.GetPeopleOnCurrentLanguageAndCity("лида","славянский");
            dataBaseConnector.GetCitiesOnPeopleType("боярин");
            dataBaseConnector.GetCityOnPeopleCounty(1827);
            dataBaseConnector.GetOldestPeopleType();
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        finally {
            dataBaseConnector.CloseConnection();
        }
    }
}
import java.sql.SQLException;

public interface IQuery {
    void GetPeopleOnCurrentLanguageAndCity(String city_name, String lang) throws SQLException;
    public void GetCitiesOnPeopleType(String peopleType) throws SQLException;
    public void GetCityOnPeopleCounty(int quantity) throws SQLException;
    public void GetOldestPeopleType() throws SQLException;
}

import java.sql.SQLException;

public interface IOpenCloseConnection {
    void OpenConnection() throws SQLException;
    void CloseConnection() throws SQLException;
}

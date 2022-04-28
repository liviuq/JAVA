import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database
{
    public static int numberOfDatabases = 0;
    private static final String URL =
            "jdbc:postgresql://localhost:5432/postgres";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Infoisshit!";

    private static Connection connection = null;

    private Database()
    {
    }

    public static Connection getConnection() throws SQLException
    {
        if(numberOfDatabases == 0)
        {
            createConnection();
            numberOfDatabases = 1;
        }

        return connection;
    }

    private static void createConnection() throws SQLException
    {
        Properties connectionProps = new Properties();
        connectionProps.put("user", USER);
        connectionProps.put("password", PASSWORD);

        connection = DriverManager.getConnection(URL, connectionProps);

        System.out.printf("[SERVER] Created connection\n");
        connection.setAutoCommit(false);
    }

    public static void closeConnection() throws SQLException
    {
        if(numberOfDatabases == 1)
        {
            connection.close();
            numberOfDatabases = 0;
        }
    }
}

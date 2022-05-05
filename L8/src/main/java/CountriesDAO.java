import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountriesDAO
{
    public void create (String name) throws SQLException
    {
        Connection connection = Database.getConnection();
        try
        {
            PreparedStatement query = connection.prepareStatement(
                    "insert into continents values (?,?)");
            query.setInt(1, getMaxId());
            query.setString(2, name);
            int row = query.executeUpdate();
            System.out.printf("[SERVER] Rows affected: %d\n", row);
        }
        catch (SQLException e)
        {
            System.out.printf("[CONNECTION ERROR] Couldn't create continent: %s\n", e);
        }
    }

    public Integer findByName (String name) throws SQLException
    {
        Connection connection = Database.getConnection();
        ResultSet result = null;
        try
        {
            PreparedStatement query = connection.prepareStatement(
                    "select id from continents where name = ?"
            );
            query.setString(1, name);
            result = query.executeQuery();

        }
        catch (SQLException e)
        {
            System.out.printf("[CONNECTION ERROR] Couldn't retrieve continent ID: %s\n", e);
        }

        assert result != null;
        return result.next() ? result.getInt(1) : null;
    }

    public String findById(int id) throws SQLException
    {
        Connection connection = Database.getConnection();
        ResultSet result = null;
        try
        {
            PreparedStatement query = connection.prepareStatement(
                    "select name from continents where id = ?"
            );
            query.setInt(1, id);
            result = query.executeQuery();

        }
        catch (SQLException e)
        {
            System.out.printf("[CONNECTION ERROR] Couldn't retrieve continent ID: %s\n", e);
        }

        assert result != null;
        return result.next() ? result.getString(1) : "inexistent";
    }

    private Integer getMaxId() throws SQLException
    {
        Connection connection = Database.getConnection();
        ResultSet result = null;
        try
        {
            PreparedStatement query = connection.prepareStatement(
                    "select max(id) from continents"
            );
            result = query.executeQuery();

        }
        catch (SQLException e)
        {
            System.out.printf("[CONNECTION ERROR] Couldn't retrieve continent ID: %s\n", e);
        }

        assert result != null;
        return result.next() ? result.getInt(1) + 1 : -1;
    }
}

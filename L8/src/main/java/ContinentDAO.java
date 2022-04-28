import java.sql.*;

public class ContinentDAO
{
    public void create (String name) throws SQLException
    {
        Connection connection = Database.getConnection();
        try
        {
            PreparedStatement query = connection.prepareStatement(
                    "insert into continents values (?,?)");
            query.setString(1, name);
            query.setInt(2, getMaxId());
            query.executeUpdate();
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

//    public String findById(int id) throws SQLException
//    {
//
//    }

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
        return result.next() ? result.getInt(1) : -1;
    }
}

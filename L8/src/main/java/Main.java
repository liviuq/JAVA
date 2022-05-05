import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        var continents = new ContinentDAO();
        try
        {
            continents.create("australia");
            Database.getConnection().commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        try {
            var id = continents.findByName("jabraska");
            var name = continents.findById(0);
            System.out.printf("id: %d, name: %s\n", id, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        var continents = new ContinentDAO();
        try {
            continents.create("jabraska");
            //Database.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            var id = continents.findByName("jabraska");
            System.out.printf("%d\n", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

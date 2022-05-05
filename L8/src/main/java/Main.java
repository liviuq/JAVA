import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        ContinentDAO continents = new ContinentDAO();
        try
        {
            continents.create("asia");
            Database.getConnection().commit();
        }
        catch (SQLException e)
        {
            System.out.printf("[SERVER] Error on sql: %s\n", e);
        }

        try
        {
            Integer id = continents.findByName("new americana"); //returns null because it does not exist
            String name = continents.findById(2);
            System.out.printf("id: %d, name: %s\n", id, name);
        }
        catch (SQLException e)
        {
            System.out.printf("[SERVER] Error on sql: %s\n", e);
        }

        CountriesDAO countries = new CountriesDAO();
        try
        {
            countries.create("Romania", "RO", "europe");
            countries.create("France", "FR", "europe");
            Database.getConnection().commit();
        }
        catch (SQLException e)
        {
            System.out.printf("[SERVER] Error on sql: %s\n", e);
        }

        try
        {
            Integer id = countries.findByName("Romania");
            String name = countries.findById(1);
            System.out.printf("id: %d, name: %s\n", id, name);
        }
        catch (SQLException e)
        {
            System.out.printf("[SERVER] Error on sql: %s\n", e);
        }

        Capitals capitals = new Capitals();
        //capitals.load("concap.csv");
        try {
            Database.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        double distance = capitals.distance("Bucharest", "Paris");
        System.out.printf("Bucharest to Paris: %f\n", distance);
    }
}

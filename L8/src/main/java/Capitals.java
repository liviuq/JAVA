import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Capitals
{
    public Capitals()
    {
    }

    //load capitals into the database
    public boolean load(String file)
    {
        //using opencsv to parse the file
        try (CSVReader reader = new CSVReader(new FileReader(file)))
        {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null)
            {
                Connection connection = Database.getConnection();

                PreparedStatement query = connection.prepareStatement(
                        "insert into capitals values (?,?,?,?,?,?)");
                query.setString(1, lineInArray[0]);
                query.setString(2, lineInArray[1]);
                query.setFloat(3, Float.parseFloat(lineInArray[2]));
                query.setFloat(4, Float.parseFloat(lineInArray[3]));
                query.setString(5, lineInArray[4]);
                query.setString(6, lineInArray[5]);
                int row = query.executeUpdate();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (CsvValidationException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    //compute the 'as-the-crow-flies' distance
    //between 2 given capitals
    public double distance(String capital1, String capital2)
    {
        Connection connection = null;
        ResultSet result1 = null;
        ResultSet result2 = null;

        try
        {
            connection = Database.getConnection();

            //get lat and long of capital1
            PreparedStatement query = connection.prepareStatement(
                    "select * from capitals where trim(name) = ?");
            query.setString(1, capital1);
            result1 = query.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert result1 != null;
        //save first coordinates
        double capital1Latitude = 0, capital1Longitude = 0;
        try
        {
            if(result1.next())
            {
                capital1Latitude = Double.parseDouble(result1.getString(3));
                capital1Longitude = Double.parseDouble(result1.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try
        {
            connection = Database.getConnection();

            //get lat and long of capital2
            PreparedStatement query = connection.prepareStatement(
                    "select * from capitals where trim(name) = ?");
            query.setString(1, capital2);
            result2 = query.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert result2 != null;
        //save second coordinates
        double capital2Latitude = 0, capital2Longitude = 0;
        try
        {
            if(result2.next())
            {
                capital2Latitude = Double.parseDouble(result2.getString(3));
                capital2Longitude = Double.parseDouble(result2.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //converting from degrees to radians
        capital1Latitude = Math.toRadians(capital1Latitude);
        capital1Longitude = Math.toRadians(capital1Longitude);
        capital2Latitude = Math.toRadians(capital2Latitude);
        capital2Longitude = Math.toRadians(capital2Longitude);
        //System.out.printf("c1lat: %f, c1long: %f, c2lat: %f, c2long: %f\n", capital1Latitude, capital1Longitude, capital2Latitude, capital2Longitude);

        //Haversine formula
        double dlon = capital2Longitude - capital1Longitude;
        double dlat = capital2Latitude - capital1Latitude;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(capital1Latitude) * Math.cos(capital2Latitude)
                * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers.
        double r = 6371;

        // calculate the result
        return(c * r);
    }
}

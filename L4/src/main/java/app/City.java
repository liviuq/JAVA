package app;

import java.util.*;

public class City
{
    private String cityName;
    private Set<Intersection> intersections;
    private Set<Street> streets;

    public City(String cityName)
    {
        this.cityName = cityName;
        intersections = new HashSet<>();
        streets = new HashSet<>();
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public Set<Intersection> getIntersections()
    {
        return intersections;
    }

    public Set<Street> getStreets()
    {
        return streets;
    }

    void addIntersection(Intersection intersection)
    {
        intersections.add(intersection);
    }

    Intersection getIntersection(String name)
    {
        for(Intersection intersection : intersections)
        {
            if(intersection.getName().compareTo(name) > 0)
            {
                return  intersection;
            }
        }
        return null;
    }

    void deleteIntersection(Intersection intersection)
    {
        intersections.remove(intersection);
    }

    void addStreet(String name, float length, Intersection intersection1, Intersection intersection2)
    {
        streets.add(new Street(name, length, intersection1, intersection2));
    }

    void deleteStreet(Street street)
    {
        streets.remove(street);
    }
}

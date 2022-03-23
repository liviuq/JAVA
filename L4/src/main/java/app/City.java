package app;

import java.util.*;

public class City
{
    private String cityName;
    private List<Intersection> intersections;
    private Set<Street> streets;

    public City(String cityName)
    {
        this.cityName = cityName;
        intersections = new LinkedList<>();
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

    public List<Intersection> getIntersections()
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

    Intersection getIntersection(int position)
    {
        if(position >= 0 && position < intersections.size())
        {
            return intersections.get(position);
        }
        return null;
    }

    void deleteIntersection(Intersection intersection)
    {
        intersections.remove(intersection);
    }

    void addStreet(String name, float length, Intersection intersection1, Intersection intersection2)
    {
        if(intersection1 == intersection2)
            return;
        streets.add(new Street(name, length, intersection1, intersection2));
    }

    void deleteStreet(Street street)
    {
        streets.remove(street);
    }
}

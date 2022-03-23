package app;

import java.util.Objects;

public class Intersection {

    private String name;
    private int numberOfStreets;
    public Intersection(String name)
    {
        this.name = name;
        this.numberOfStreets = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStreets()
    {
        return numberOfStreets;
    }

    public void addToStreet()
    {
        numberOfStreets += 1;
    }

    public void removeFromStreet()
    {
        if(numberOfStreets == 0)
            return;
        numberOfStreets -= 1;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString()
    {
        return "Intersection{" +
                "name='" + name + '\'' +
                ", numberOfStreets=" + numberOfStreets +
                '}';
    }
}
package com.company;

import java.util.Comparator;
import java.util.Objects;

public class Street implements Comparable<Street>
{

    private String name;
    private float length;
    private Intersection intersection1;
    private Intersection intersection2;

    public Street(String name, float length, Intersection intersection1, Intersection intersection2) {
        this.name = name;
        this.length = length;
        this.intersection1 = intersection1;
        this.intersection2 = intersection2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Intersection getIntersection1() {
        return intersection1;
    }

    public void setIntersection1(Intersection intersection1) {
        this.intersection1 = intersection1;
    }

    public Intersection getIntersection2() {
        return intersection2;
    }

    public void setIntersection2(Intersection intersection2) {
        this.intersection2 = intersection2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Float.compare(street.length, length) == 0 && name.equals(street.getName()) && intersection1.getName().equals(intersection1.getName()) && intersection2.getName().equals(intersection2.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, intersection1, intersection2);
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", intersection1=" + intersection1 +
                ", intersection2=" + intersection2 +
                '}';
    }

    @Override
    public int compareTo(Street o)
    {
        if (this.length < o.getLength())
            return -1;
        if (this.length == o.getLength())
            return 0;
        return 1;
    }
}

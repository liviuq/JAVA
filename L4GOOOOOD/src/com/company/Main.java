package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //creating the intersections
        var intersections = IntStream.rangeClosed(0,8)
                .mapToObj(i -> new Intersection("i" + i))
                .toList();

        for(var intersection : intersections)
        {
            System.out.printf("%s\n", intersection);
        }

        //creating the streets
        List<Street> streets = new ArrayList<>();
        streets.add(new Street("s1", 2, intersections.get(0), intersections.get(1)));

        System.out.printf("%s\n", streets.get(0));
    }
}

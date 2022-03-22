package app;

import java.util.*;
import java.util.stream.Collectors;
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
        List<Street> streets = new LinkedList<>();
        streets.add(new Street("s1", 2, intersections.get(0), intersections.get(1)));
        streets.add(new Street("s2", 1, intersections.get(1), intersections.get(2)));
        streets.add(new Street("s3", 6, intersections.get(2), intersections.get(3)));
        streets.add(new Street("s4", 11, intersections.get(3), intersections.get(4)));
        streets.add(new Street("s5", 5, intersections.get(4), intersections.get(5)));

        //Collections.sort(streets);

        // sorting the streets with a lambda
        Collections.sort(streets, Comparator.comparing(Street::getLength));
        for(Street street : streets)
        {
            System.out.printf("%s %f\n", street.getName(), street.getLength());
        }

        //creating a set of intersections
        Set<Intersection> intersectionsHashSet = new HashSet<>();
        intersectionsHashSet = intersections
                .stream()
                .distinct()
                .collect(Collectors.toSet());
    }
}
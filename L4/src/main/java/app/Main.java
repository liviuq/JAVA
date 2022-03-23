package app;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        //Starting our faker beautiful name generator
        Faker faker = new Faker();

        //creating the intersections
        var intersections = IntStream.rangeClosed(0,8)
                .mapToObj(i -> new Intersection(faker.address().firstName()))
                .toList();

        //creating the streets
        List<Street> streets = new LinkedList<>();
        streets.add(new Street(faker.address().streetName(), 2, intersections.get(0), intersections.get(1)));
        streets.add(new Street(faker.address().streetName(), 1, intersections.get(1), intersections.get(2)));
        streets.add(new Street(faker.address().streetName(), 6, intersections.get(2), intersections.get(3)));
        streets.add(new Street(faker.address().streetName(), 11, intersections.get(3), intersections.get(4)));
        streets.add(new Street(faker.address().streetName(), 5, intersections.get(4), intersections.get(5)));

        //Collections.sort(streets);

        // sorting the streets with a lambda
        Collections.sort(streets, Comparator.comparing(Street::getLength));

        //creating a set of intersections
        Set<Intersection> intersectionsHashSet = new HashSet<>();
        intersectionsHashSet = intersections
                .stream()
                .distinct()
                .collect(Collectors.toSet());

        //Creating our city
        City javangeles = new City("Javangeles");

        //populating javangeles with intersections
        for(var intersection : intersections)
        {
            javangeles.addIntersection(intersection);
        }

        //printing the intersections
        javangeles.getIntersections()
                .forEach(System.out::println);

        javangeles.addStreet(faker.address().streetName(), 2, javangeles.getIntersection(0), javangeles.getIntersection(8));
        javangeles.addStreet(faker.address().streetName(), 5, javangeles.getIntersection(0), javangeles.getIntersection(7));
        javangeles.addStreet(faker.address().streetName(), 7, javangeles.getIntersection(0), javangeles.getIntersection(1));
        javangeles.addStreet(faker.address().streetName(), 9, javangeles.getIntersection(8), javangeles.getIntersection(7));
        javangeles.addStreet(faker.address().streetName(), 1, javangeles.getIntersection(1), javangeles.getIntersection(7));
        javangeles.addStreet(faker.address().streetName(), 2, javangeles.getIntersection(8), javangeles.getIntersection(6));
        javangeles.addStreet(faker.address().streetName(), 3, javangeles.getIntersection(7), javangeles.getIntersection(5));
        javangeles.addStreet(faker.address().streetName(), 5, javangeles.getIntersection(7), javangeles.getIntersection(2));
        javangeles.addStreet(faker.address().streetName(), 6, javangeles.getIntersection(6), javangeles.getIntersection(2));
        javangeles.addStreet(faker.address().streetName(), 8, javangeles.getIntersection(6), javangeles.getIntersection(3));
        javangeles.addStreet(faker.address().streetName(), 1, javangeles.getIntersection(6), javangeles.getIntersection(4));
        javangeles.addStreet(faker.address().streetName(), 5, javangeles.getIntersection(5), javangeles.getIntersection(4));
        javangeles.addStreet(faker.address().streetName(), 7, javangeles.getIntersection(5), javangeles.getIntersection(3));
        javangeles.addStreet(faker.address().streetName(), 8, javangeles.getIntersection(4), javangeles.getIntersection(3));

        //reading the length from the keyboard
        Scanner scanner = new Scanner(System.in);
        int streetLength = scanner.nextInt();

        //displaying the streets longer than a specified value
        //and join at least 3 streets

       javangeles.getStreets().stream()
               .filter(street -> street.getLength() >= streetLength)
                .forEach(System.out::println);

    }
}
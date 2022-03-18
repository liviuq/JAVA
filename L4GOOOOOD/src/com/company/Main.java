package com.company;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //creating the intersections
        var intersections = IntStream.rangeClosed(0,5)
                .mapToObj(i -> new Intersection("i" + i))
                .toList();

        for(var intersection : intersections)
        {
            System.out.printf("%s\n", intersection);
        }
    }
}

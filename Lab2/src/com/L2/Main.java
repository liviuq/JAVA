package com.L2;

public class Main {

    public static void main(String[] args)
    {
        //creating some rooms
        Room room1 = new Room("C301", RoomType.Type.LECTURE_HALL, 100);
        Room room2 = new Room("L2", RoomType.Type.LABBORATORY, 25);

        //creating some events
        Event event1 = new Event("Java", 20, 10, 12);
        Event event2 = new Event("SGBD", 20, 8, 10);

        System.out.printf("%s\n", room1);
        System.out.printf("%s\n", room2);
        System.out.printf("%s\n", event1);
        System.out.printf("%s\n", event2);
    }
}

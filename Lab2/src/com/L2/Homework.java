package com.L2;

import algorithm.Algorithm;
import algorithm.AndrewsAlgorithm;
import algorithm.Problem;
import event.Event;
import room.Laboratory;
import room.Room;

import java.util.ArrayList;
import java.util.List;

public class Homework
{
    public static void main(String[] args)
    {
        List<Room> rooms = new ArrayList<>();
        Room.addRoom(new Laboratory("L1", 30, 30, "Linux"), rooms);
        Room.addRoom(new Laboratory("L2", 22, 22, "Windows 98"), rooms);
        Room.addRoom(new Laboratory("L3", 24, 24, "Win 11"), rooms);
        Room.addRoom(new Laboratory("L4", 25, 25, "Ubuntu"), rooms);
        Room.printRooms(rooms);

        List<Event> events = new ArrayList<>();
        Event.addEvent(new Event("C1", 8, 10, 15), events);
        Event.addEvent(new Event("C2", 10, 12, 20), events);
        Event.addEvent(new Event("C3", 16, 18, 22), events);
        Event.addEvent(new Event("C4", 12, 14, 30), events);
        Event.addEvent(new Event("C5", 12, 14, 35), events);
        Event.printEvents(events);

        Problem pb = new Problem();
        pb.addEvent(events);
        pb.addRoom(rooms);

        System.out.print("------------------\n");

        Algorithm myAlgorithm = new AndrewsAlgorithm();
        myAlgorithm.solve(pb);
    }
}

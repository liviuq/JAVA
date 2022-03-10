package com.L2;

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
        Room.addRoom(new Laboratory("L1", 20, 20, "Linux"), rooms);
        Room.addRoom(new Laboratory("L2", 22, 22, "Windows 98"), rooms);
        Room.addRoom(new Laboratory("L3", 24, 24, "Win 11"), rooms);
        Room.addRoom(new Laboratory("L4", 25, 25, "Ubuntu"), rooms);
        Room.printRooms(rooms);

        List<Event> events = new ArrayList<>();
        Event.addEvent(new Event("C1", 8, 10, 200), events);
        Event.addEvent(new Event("C2", 10, 12, 100), events);
        Event.addEvent(new Event("C3", 16, 18, 250), events);
        Event.addEvent(new Event("C4", 12, 14, 50), events);
        Event.printEvents(events);
    }
}

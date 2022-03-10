package algorithm;

import event.Event;
import room.Room;

import java.util.ArrayList;
import java.util.List;

public class Problem
{
    private List<Event> events;
    private List<Room> rooms;

    public Problem()
    {
        events = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public List<Event> getEvents()
    {
        return events;
    }

    public void setEvents(List<Event> events)
    {
        this.events = events;
    }

    public List<Room> getRooms()
    {
        return rooms;
    }

    public void setRooms(List<Room> rooms)
    {
        this.rooms = rooms;
    }

    public void addRoom(Room... rooms)
    {
        for(Room room : rooms)
        {
            Room.addRoom(room, this.rooms);
        }
    }

    public void addEvent(Event... events)
    {
        for(Event event : events)
        {
            Event.addEvent(event, this.events);
        }
    }

    public void addRoom(List<Room> rooms)
    {
        for(Room room : rooms)
        {
            this.rooms.add(room);
        }
    }

    public void addEvent(List<Event> events)
    {
        for(Event event : events)
        {
            this.events.add(event);
        }
    }

    public void printRooms()
    {
        for(Room room : rooms)
        {
            System.out.printf("%s\n", room);
        }
    }

    public void printEvents()
    {
        for(Event event : events)
        {
            System.out.printf("%s\n", event);
        }
    }
}

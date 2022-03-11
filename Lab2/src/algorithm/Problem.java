package algorithm;

import event.Event;
import room.Room;

import java.util.ArrayList;
import java.util.List;

public class Problem
{
    //A problem consists of two lists of events and rooms
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

    /**
     * Variadic method to add rooms just like in printf
     * @param rooms
     */
    public void addRoom(Room... rooms)
    {
        for(Room room : rooms)
        {
            Room.addRoom(room, this.rooms);
        }
    }

    /**
     * Variadic method to add events just like in printf
     * @param events
     */
    public void addEvent(Event... events)
    {
        for(Event event : events)
        {
            Event.addEvent(event, this.events);
        }
    }

    /**
     * Adds all the rooms to the problem, provided a list of rooms beforehand
     * @param rooms
     */
    public void addRoom(List<Room> rooms)
    {
        for(Room room : rooms)
        {
            this.rooms.add(room);
        }
    }

    /**
     * Adds all the events to the problem, provided a list of events beforehand
     * @param events
     */
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

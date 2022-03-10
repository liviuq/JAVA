package event;

import room.Room;

import java.util.List;
import java.util.Objects;

public class Event
{
    protected String name;
    protected int startHour;
    protected int endHour;
    protected int capacity;

    public Event(String name, int startHour, int endHour, int capacity)
    {
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
        this.capacity = capacity;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getStartHour()
    {
        return startHour;
    }

    public void setStartHour(int startHour)
    {
        this.startHour = startHour;
    }

    public int getEndHour()
    {
        return endHour;
    }

    public void setEndHour(int endHour)
    {
        this.endHour = endHour;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public static boolean addEvent(Event event, List<Event> events)
    {
        if(events == null) return false;
        for(Event anotherEvent : events)
        {
            if(event.equals(anotherEvent))
                return false;
        }
        events.add(event);
        return true;
    }

    public static void printEvents(List<Event> events)
    {
        for(Event event: events)
        {
            System.out.printf("%s\n", event);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return startHour == event.startHour && endHour == event.endHour && capacity == event.capacity && name.equals(event.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, startHour, endHour, capacity);
    }

    @Override
    public String toString()
    {
        return "Event{" +
                "name='" + name + '\'' +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", capacity=" + capacity +
                '}';
    }
}

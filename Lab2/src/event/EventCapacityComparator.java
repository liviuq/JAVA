package event;

import java.util.Comparator;

public class EventCapacityComparator implements Comparator<Event>
{
    @Override
    public int compare(Event event1, Event event2)
    {
        if( event1.getCapacity() == event2.getCapacity()) return 0;
        if( event1.getCapacity() > event2.getCapacity()) return 1;
        if( event1.getCapacity() < event2.getCapacity()) return -1;
        return -1;
    }
}


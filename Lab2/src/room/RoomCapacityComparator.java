package room;

import java.util.Comparator;

public class RoomCapacityComparator implements Comparator<Room>
{

    @Override
    public int compare(Room room1, Room room2)
    {
        if( room1.getCapacity() == room2.getCapacity()) return 0;
        if( room1.getCapacity() > room2.getCapacity()) return 1;
        if( room1.getCapacity() < room2.getCapacity()) return -1;
        return -1;
    }
}
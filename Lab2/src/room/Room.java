package room;

import java.util.List;
import java.util.Objects;

public abstract class Room
{
    protected String name;
    protected int capacity;

    public Room(String name, int capacity)
    {
        this.name = name;
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

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    /**
     * Adds a room to an existing list of rooms
     * @param room
     * @param rooms
     * @return boolean
     */
    public static boolean addRoom(Room room, List<Room> rooms)
    {
        if(rooms == null) return false;
        for(Room anotherRoom : rooms)
        {
            if(room.equals(anotherRoom))
                return false;
        }
        rooms.add(room);
        return true;
    }

    public static void printRooms(List<Room> rooms)
    {
        for(Room room: rooms)
        {
            System.out.printf("%s\n", room);
        }
    }

    @Override
    public String toString()
    {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && name.equals(room.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, capacity);
    }
}

package com.L2;

public class Room
{
    private String name;
    private RoomType.Type roomType;
    private int capacity;

    public Room(String name, RoomType.Type roomType, int capacity)
    {
        this.name = name;
        this.roomType = roomType;
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

    public RoomType.Type getRoomType()
    {
        return roomType;
    }

    public void setRoomType(RoomType.Type roomType)
    {
        this.roomType = roomType;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String toString()
    {
        return "Room{" +
                "name='" + name + '\'' +
                ", roomType=" + roomType +
                ", capacity=" + capacity +
                '}';
    }
}

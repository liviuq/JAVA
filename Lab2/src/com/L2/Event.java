package com.L2;

public class Event
{
    private String name;
    private int numberOfParticipants;
    private int startTime;
    private int endTime;

    public Event(String name, int numberOfParticipants, int startTime, int endTime)
    {
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants)
    {
        this.numberOfParticipants = numberOfParticipants;
    }

    public int getStartTime()
    {
        return startTime;
    }

    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    public int getEndTime()
    {
        return endTime;
    }

    public void setEndTime(int endTime)
    {
        this.endTime = endTime;
    }

    @Override
    public String toString()
    {
        return "Event{" +
                "name='" + name + '\'' +
                ", numberOfParticipants=" + numberOfParticipants +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

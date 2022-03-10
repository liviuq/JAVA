package algorithm;

import room.Room;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    private List<Room> assignment;

    public Solution()
    {
        assignment = new ArrayList<>();
    }

    public List<Room> getAssignment()
    {
        return assignment;
    }

    public void setAssignment(List<Room> assignment)
    {
        this.assignment = assignment;
    }

    public Room getAssignment(int index)
    {
        return assignment.get(index);
    }
}

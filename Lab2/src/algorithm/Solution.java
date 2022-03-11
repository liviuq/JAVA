package algorithm;

import event.Event;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    private List<Event> assignment;

    public Solution()
    {
        assignment = new ArrayList<>();
    }

    public List<Event> getAssignment()
    {
        return assignment;
    }

    public void setAssignment(List<Event> assignment)
    {
        this.assignment = assignment;
    }

    public Event getAssignment(int index)
    {
        return assignment.get(index);
    }

    public void printSolution()
    {
        for(Event event : assignment)
        {
            System.out.printf("%s\n", event);
        }
    }
}

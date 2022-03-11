package algorithm;

import event.Event;
import event.EventCapacityComparator;
import room.Room;
import room.RoomCapacityComparator;

public class AndrewsAlgorithm extends Algorithm
{
    public AndrewsAlgorithm()
    {
    }

    /**
     * This method "tries" to solve the problem in a greedy manner
     * It sorts the events and rooms by capacity and assigns events to rooms
     * if the room is not occupied and the room has enough capacity
     * @param problem
     */
    @Override
    public void solve(Problem problem)
    {
        Solution solution = new Solution();

        //Sorting the lists with a Comparator class found in src.event and src.room
        problem.getRooms().sort(new RoomCapacityComparator());
        problem.getEvents().sort(new EventCapacityComparator());

        for(Room room : problem.getRooms())
        {
            for(Event event : problem.getEvents())
            {
                //if room is not occupied and has enough seats
                if(room.getStartTime() == -1 && room.getCapacity() >= event.getCapacity())
                {
                    System.out.println(event.getName() + " : " + room.getName());
                    room.setStartTime(event.getStartHour());
                    room.setEndTime(event.getEndHour());
                    break;
                }
                else
                {
                    //if room might be occupied but it s free before event starts
                    if(room.getEndTime() != -1 && room.getEndTime() <= event.getStartHour() && room.getCapacity() >= event.getCapacity())
                    {
                        System.out.println(event.getName() + " : " + room.getName());
                        room.setStartTime(event.getStartHour());
                        room.setEndTime(event.getEndHour());
                        break;
                    }
                }
            }
        }
    }
}

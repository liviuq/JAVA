package room;

import java.util.Objects;

public class LectureHall extends Room
{
    protected int numberOfProjectors;
    protected boolean seatsHaveOutlet;

    public LectureHall(String name, int capacity, int numberOfProjectors, boolean seatsHaveOutlet)
    {
        super(name, capacity);
        this.numberOfProjectors = numberOfProjectors;
        this.seatsHaveOutlet = seatsHaveOutlet;
    }

    public int getNumberOfProjectors()
    {
        return numberOfProjectors;
    }

    public void setNumberOfProjectors(int numberOfProjectors)
    {
        this.numberOfProjectors = numberOfProjectors;
    }

    public boolean isSeatsHaveOutlet()
    {
        return seatsHaveOutlet;
    }

    public void setSeatsHaveOutlet(boolean seatsHaveOutlet)
    {
        this.seatsHaveOutlet = seatsHaveOutlet;
    }

    @Override
    public String toString()
    {
        return "LectureHall{" +
                "numberOfProjectors=" + numberOfProjectors +
                ", seatsHaveOutlet=" + seatsHaveOutlet +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LectureHall that = (LectureHall) o;
        return numberOfProjectors == that.numberOfProjectors && seatsHaveOutlet == that.seatsHaveOutlet;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), numberOfProjectors, seatsHaveOutlet);
    }
}

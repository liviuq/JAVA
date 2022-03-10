package room;

public class Laboratory extends Room
{
    protected int numberOfComputers;
    protected String operatingSystem;

    public Laboratory(String name, int capacity, int numberOfComputers, String operatingSystem)
    {
        super(name, capacity);
        this.numberOfComputers = numberOfComputers;
        this.operatingSystem = operatingSystem;
    }

    public int getNumberOfComputers()
    {
        return numberOfComputers;
    }

    public void setNumberOfComputers(int numberOfComputers)
    {
        this.numberOfComputers = numberOfComputers;
    }

    public String getOperatingSystem()
    {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem)
    {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString()
    {
        return "Laboratory{" +
                "numberOfComputers=" + numberOfComputers +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

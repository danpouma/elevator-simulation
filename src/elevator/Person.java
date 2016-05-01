package elevator;

/**
 *
 * @author dpoumakis
 */
public class Person
{
    private int startFloor;
    private int stopFloor;
    private int startTime;
    private int stopTime;

    private final int id;
    private static int idGenerator = 0;

    public Person()
    {
        startFloor = 0;
        startTime = 0;
        stopTime = 0;

        id = idGenerator++;
    }

    public Person(int startFloor)
    {
        this.startFloor = startFloor;
        startTime = 0;
        stopTime = 0;

        id = idGenerator++;
    }

    public Person(int startFloor, int stopFloor)
    {
        this.startFloor = startFloor;
        this.stopFloor = stopFloor;
        startTime = 0;
        stopTime = 0;

        id = idGenerator++;
    }

    public static int getIdGenerator()
    {
        return idGenerator;
    }

    public void setStartFloor(int startFloor)
    {
        this.startFloor = startFloor;
    }

    public int getStartFloor()
    {
        return this.startFloor;
    }

    public void setStopFloor(int stopFloor)
    {
        this.stopFloor = stopFloor;
    }

    public int getStopFloor()
    {
        return this.stopFloor;
    }

    public int getStartTime()
    {
        return this.startTime;
    }

    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    public int getStopTime()
    {
        return this.stopTime;
    }

    public void setStopTime(int stopTime)
    {
        this.stopTime = stopTime;
    }

    public int getId()
    {
        return this.id;
    }

    public boolean isGoingUp()
    {
        boolean isGoingUp = true;

        if (stopFloor < startFloor)
        {
            isGoingUp = false;
        } 
        else if (startFloor == stopFloor)
        {
            // Should be getting off
        }
        else
        {
            // Do nothing
        }
        return isGoingUp;
    }

    public int getTotalTime()
    {
        return this.stopTime - this.startTime;
    }

    @Override
    public String toString()
    {
        return "Person{" + "id=" + id + '}';
    }
}

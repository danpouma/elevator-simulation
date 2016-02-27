package elevator;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class Person
{
    // Make id constant
    private final int id;
    
    private int startFloor;
    private int stopFloor;
    
    private int time;
    
    private int maxFloor;
    
    private boolean goingUp;
    private boolean goingDown;
    
    // Is it ok to declare 0 here? double check
    private static int counter = 0;

    public Person()
    {
        // is this id working correctly
        this.id = counter++;
        this.maxFloor = Config.maxFloor;
        this.goingDown = false;
        this.goingUp = false;
    }
    
    public Person(int startFloor) 
    {
        this.id = counter++;
        this.startFloor = startFloor;
        this.goingDown = false;
        this.goingUp = false;
    }

    // Can automate which direction they're going via this function!
    public Person(int startFloor, int stopFloor) 
    {
        this.id = counter++;
        this.startFloor = startFloor;
        this.stopFloor = stopFloor;
        
        if (startFloor < stopFloor)
        {
            goingUp = true;
            goingDown = false;
        }
        else
        {
            goingDown = true;
            goingUp = false;
        }
        
    }

    public int getId()
    {
        return id;
    }

    public int getStartFloor()
    {
        return startFloor;
    }

    public void setStartFloor(int startFloor)
    {
        this.startFloor = startFloor;
    }

    public int getStopFloor()
    {
        return stopFloor;
    }

    public void setStopFloor(int stopFloor)
    {
        this.stopFloor = stopFloor;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public int getMaxFloor()
    {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor)
    {
        this.maxFloor = maxFloor;
    }

    public boolean isGoingUp()
    {
        // Add automation for check up
        if (startFloor < stopFloor)
        {
            goingUp = true;
            goingDown = false;
        }
        else
        {
            goingUp = false;
            goingDown = true;
        }
        return goingUp;
    }

    public void setGoingUp(boolean goingUp)
    {
        this.goingUp = goingUp;
    }

    public boolean isGoingDown()
    {
        // Add automation for check down
        if (startFloor < stopFloor)
        {
            goingUp = true;
            goingDown = false;
        }
        else
        {
            goingUp = false;
            goingDown = true;
        }
        return goingDown;
    }

    public void setGoingDown(boolean goingDown)
    {
        this.goingDown = goingDown;
    }
    
    @Override
    public String toString()
    {
        // make this type casted?
        return id + "";
    }
}
package elevator;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class Config
{
    // rename this to numberOfFloors
    public static int maxFloor = 10;
    
    public static int elevatorCapacity = 15;
    
    public void setMaxFloor(int maxFloor)
    {
        Config.maxFloor = maxFloor;
    }
    
    public int getMaxFloor()
    {
        return Config.maxFloor;
    }
    
    public void setElevatorCapacity(int capacity)
    {
        Config.elevatorCapacity = capacity;
    }
    
    public int getElevatorCapacity()
    {
        return Config.elevatorCapacity;
    }
}

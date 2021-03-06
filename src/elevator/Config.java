package elevator;

/**
 *
 * @author dpoumakis
 */
public class Config
{

    public static final int UP = 1;

    public static final int DOWN = 0;

    public static int maxFloor = 10;

    public static int numberOfElevators = 1;

    public static int elevatorCapacity = 10;

    public static int numberOfPeople = 50;

    public static int ascentType = 0;

    public static void setMaxFloor(int maxFloor)
    {
        Config.maxFloor = maxFloor;
    }

    public static void setNumberOfElevators(int numberOfElevators)
    {
        Config.numberOfElevators = numberOfElevators;
    }

    public static void setElevatorCapacity(int capacity)
    {
        Config.elevatorCapacity = capacity;
    }

    public static void setNumberOfPeople(int numberOfPeople)
    {
        Config.numberOfPeople = numberOfPeople;
    }

    public static void setAssentType(int assentType)
    {
        Config.ascentType = assentType;
    }
}

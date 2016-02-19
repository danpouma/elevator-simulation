package elevatorTest;

import elevator.*;

/**
 *
 * @author dpoumakis
 */
public class FloorArrayTest
{
    public static void main(String[] args)
    {
        // Create floor array
        FloorArray floors = new FloorArray();
        
        // Test number of floors was set correctly
        if (floors.getNumberOfFloors() == Config.maxFloor)
        {
            System.out.println("Test: Number of floors - Pass");
        }
        else
        {
            System.out.println("Test: Number of floors - Fail");
        }
        
        // For each floor add two people (1 up 1 down)
        for (int floor = 0; floor < floors.getNumberOfFloors(); floor++)
        {
            // Start top go to bottom
            floors.getFloor(floor).addPerson(new Person(0, Config.maxFloor));
            // Start bottom go to top
            floors.getFloor(floor).addPerson(new Person(Config.maxFloor - 1, 0));
        }
        
        // Test each floors queues aren't empty
        boolean foundEmptyQueue = false;
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = floors.getFloor(floor);
            if (!currentFloor.upIsOn() && !currentFloor.downIsOn())
            {
                foundEmptyQueue = true;
            }
        }
        if (foundEmptyQueue)
        {
            System.out.println("Test: Queues aren't empty - Fail");
        }
        else
        {
            System.out.println("Test: Queues aren't empty - Pass");
        }
    }
    
}

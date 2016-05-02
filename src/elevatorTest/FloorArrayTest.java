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
        
         // I will start at bottom floor and get off at top
        Person me = new Person(0, Config.maxFloor - 1);
        
        // You will start at top floor and get off at top
        Person you = new Person(Config.maxFloor - 1, 0);
        
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
            floors.addPerson(me, floor);
            
            floors.addPerson(you, floor);
        }
        
        // Test each floors queues aren't empty
        boolean foundEmptyQueue = false;
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = floors.getFloor(floor);
            if (currentFloor.getUpQueue().isEmpty() || currentFloor.getDownQueue().isEmpty())
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
        
        // For each floor remove 2 people
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            floors.getFromUpQueue(floor);
            floors.getFromDownQueue(floor);
        }
        
        // test that queues are now empty
        boolean emptyQueueFound = false;
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = floors.getFloor(floor);
            if (currentFloor.getUpQueue().isEmpty() && currentFloor.getDownQueue().isEmpty())
            {
                emptyQueueFound = true;
            }
        }
        if (emptyQueueFound)
        {
            System.out.println("Test: Queues are empty - Pass");
        }
        else
        {
            System.out.println("Test: Queues are empty - Fail");
        }
    } 
}

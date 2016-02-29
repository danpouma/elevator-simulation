package elevatorTest;

import elevator.*;
import java.util.Random;

/**
 *
 * @author dpoumakis
 */
public class BuildingTest
{
    public static void main(String[] args)
    {
        // Create random number generator and set seed (time)
        Random randomGenerator = new Random(System.currentTimeMillis());
        
        // Create building
        Building building = new Building();
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = building.getFloors().getFloor(floor);
            
            for (int people = 0; people < 1000; people++)
            {
                Boolean invalidStop = false;
                do
                {   
                    int randomStart = randomGenerator.nextInt(10);
                    int randomStop = randomGenerator.nextInt(10);

                    if (randomStart != randomStop)
                    {
                        currentFloor.addPerson(new Person(randomStart, randomStop));
                        invalidStop = false;
                    }
                    else
                    {
                        invalidStop = true;
                    }
                } while (invalidStop);
            }
            
            System.out.println(currentFloor.getUpQueue().getSize() + currentFloor.getDownQueue().getSize());
        }
        
        
        
        
        
        
        
        
        //Test 1: Move people from the bottom floor to the top floor
        for (int people = 0; people < Config.elevatorCapacity; people++)
        {
            building.addPerson(new Person(0, 9), 0);
        }
        if (building.getFloors().getFloor(0).isEmpty())
        {
            System.out.println("Test: Fill floor 0 - Fail");
        }
        else
        {
            System.out.println("Test: Fill floor 0 - Pass");
        }
        
        Elevator[] elevators = building.getElevators();
        
        while (!building.getFloors().getFloor(0).isEmpty())
        {
            elevators[0].addPerson(building.getFloors().getFloor(0).getFromUpQueue());
        }
        if (building.getFloors().getFloor(0).isEmpty() && elevators[0].peopleGoingUp())
        {
            System.out.println("Test: Empty floor 0 && people going up - Pass");
        }
        else
        {
            System.out.println("Test: Empty floor 0 && people going up - Fail");
        }
        
        
        building.moveElevator();
        if (building.getFloors().getFloor(9).isEmpty() && elevators[0].isEmpty())
        {
            System.out.println("Test: Removed people on floor 10 - Pass");
        }
        else
        {
            System.out.println("Test: Removed poeple on floor 10 - Fail");
        }
    }
}

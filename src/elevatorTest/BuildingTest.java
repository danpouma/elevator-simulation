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
        }
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = building.getFloors().getFloor(floor);
    
            building.moveElevator();        
            
            System.out.println("Floor " + floor + ": " + currentFloor.numberOfPeople());
        }
    }
}

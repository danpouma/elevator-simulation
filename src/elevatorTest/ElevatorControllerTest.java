package elevatorTest;

import elevator.*;

/**
 *
 * @author dpoumakis
 */
public class ElevatorControllerTest
{
    public static void main(String[] args)
    {
        ElevatorController controller = new ElevatorController();
        FloorArray floors = new FloorArray();
        Elevator[] elevators = new Elevator[1];
        for (int elevator = 0; elevator < elevators.length; elevator++)
        {
            elevators[elevator] = new Elevator();
        }
        
        
        //Test 1: Move people from the bottom floor to the top floor
        for (int people = 0; people < Config.elevatorCapacity; people++)
        {
            floors.addPerson(new Person(0, 9), 0);
        }
        if (floors.getFloor(0).isEmpty())
        {
            System.out.println("Test: Fill floor 0 - Fail");
        }
        else
        {
            System.out.println("Test: Fill floor 0 - Pass");
        }
        
        while (!floors.getFloor(0).isEmpty())
        {
            elevators[0].addPerson(floors.getFloor(0).getFromUpQueue());
        }
        if (floors.getFloor(0).isEmpty() && elevators[0].peopleGoingUp())
        {
            System.out.println("Test: Empty floor 0 && people going up - Pass");
        }
        else
        {
            System.out.println("Test: Empty floor 0 && people going up - Fail");
        }
        
        
        
        
        
        
        
        
        
   
        
        
        // Wait till i prep everything else
        //controller.moveElevator(floors, elevators);
    }
}

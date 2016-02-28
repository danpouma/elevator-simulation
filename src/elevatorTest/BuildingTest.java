package elevatorTest;

import elevator.*;

/**
 *
 * @author dpoumakis
 */
public class BuildingTest
{
    public static void main(String[] args)
    {
        // Create building
        Building building = new Building();

  
        
        
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
        
        System.out.println(elevators[0].getPeople().size());
        building.moveElevator();
        System.out.println(elevators[0].getPeople().size());
    }
}

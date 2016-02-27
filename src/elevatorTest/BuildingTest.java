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
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            // Add a person to each floor all get off at top floor
            building.addPerson(new Person(0, 3), floor);
            System.out.println(building.getFloors().getFloor(floor).isEmpty());
            
        }
        
        //building.moveElevator();
    }
}

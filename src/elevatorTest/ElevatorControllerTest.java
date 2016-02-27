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
        
        // Need to add people to the floors
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            // 3 people per floor
            for (int i = 0; i < 3; i++)
            {
                floors.getFloor(floor).addPerson(new Person(floor, Config.maxFloor));
            }
        }
        
        Elevator[] elevators = new Elevator[1];
        
        for (int elevator = 0; elevator < elevators.length; elevator++)
        {
            elevators[elevator] = new Elevator();
        }
        
        controller.moveElevator(floors, elevators);
    }
}

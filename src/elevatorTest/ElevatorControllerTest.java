package elevatorTest;

import elevator.Config;
import elevator.Elevator;
import elevator.ElevatorController;
import elevator.FloorArray;
import elevator.PeopleGenerator;

/**
 *
 * @author dpoumakis
 */
public class ElevatorControllerTest
{
    public static void main(String[] args)
    {
        ElevatorController elevatorController = new ElevatorController();
        
        PeopleGenerator peopleGen = new PeopleGenerator();
        
        FloorArray floors = new FloorArray();
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            for (int person = 0; person < 15; person++)
            {
                floors.addPerson(peopleGen.generatePerson(), floor);
            }
        }
        
        Elevator[] elevators = new Elevator[1];
        
        // Was this the null pointer?
        elevators[0] = new Elevator();
        
        elevatorController.moveElevator(floors, elevators);
    }
}

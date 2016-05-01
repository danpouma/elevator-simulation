package elevatorTest;

import elevator.Config;
import elevator.Elevator2;
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
            for (int person = 0; person < Config.numberOfPeople; person++)
            {
                floors.addPerson(peopleGen.generatePerson(), floor);
            }
        }
        
        Elevator2[] elevators = new Elevator2[1];
        
        // Was this the null pointer?
        elevators[0] = new Elevator2();
        
        System.out.println(elevators[0].getNumberOfOccupants());
        elevatorController.moveElevator(floors, elevators);
        System.out.println(elevators[0].getNumberOfOccupants());
        
        if (Config.numberOfPeople*Config.maxFloor == elevators[0].getNumberOfOccupants())
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("fail");
        }
    }
}

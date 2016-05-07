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
            for (int person = 0; person < Config.numberOfPeople; person++)
            {
                floors.addPerson(peopleGen.generatePerson(), floor);
            }
        }
        
        Elevator[] elevators = new Elevator[1];
        
        // Was this the null pointer?
        elevators[0] = new Elevator();
        
        System.out.println(elevators[0].getNumberOfPeople());
        
        elevatorController.elevatorGetUpQueue(floors, elevators);
        
        System.out.println(elevators[0].getNumberOfPeople());
        
        if (Config.numberOfPeople*Config.maxFloor == elevators[0].getNumberOfPeople())
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("fail");
        }
    }
}

package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class ElevatorController
{
    public ElevatorController() {}

    public void moveElevator(FloorArray floors, Elevator[] elevators)
    {
        ArrayList<Floor> floorArray = floors.getFloors();
        
        for (Elevator elevator : elevators)
        {
            for (Floor floor : floorArray)
            {
                for (int people = 0; people < 15; people++)
                {
                    Person personFromUpQueue = floor.getFromUpQueue();
                    
                    // code will occasionally completely crap out
                    if (personFromUpQueue == null)
                    {
                        System.out.println("null");
                        System.out.println("Floor: " + floor.numberOfPeople());
                        System.out.println("Elevator: " + elevator.getNumberOfOccupants());
                    }
                    else
                    {
                        elevator.addPerson(personFromUpQueue);
                    }
                }
            }
        }
    }
}

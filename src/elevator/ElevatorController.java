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
                for (int people = 0; people < 10; people++)
                {
                    Person personFromUpQueue = floor.getFromUpQueue();
                    
                    // code will occasionally completely crap out
                    // output info to figure out why
                    
                    // THe bug is floors addPerson method
                    if (personFromUpQueue == null)
                    {
                        System.out.println("null");
                        //System.out.println("Floor: " + floor.numberOfPeople());
                        //System.out.println("Elevator: " + elevator.getNumberOfOccupants());
                        //System.out.println("People: " + people);
                        System.out.println("Floor #: " + floor.getFloorNumber());
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

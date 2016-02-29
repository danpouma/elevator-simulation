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
        // Start from bottom go to top
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = floors.getFloor(floor);
            
            elevators[0].removePeople(floor);
            //System.out.println(elevators[0].getNumberOfOccupants());
            while (currentFloor.upIsOn() && !elevators[0].isFull())
            {
                elevators[0].addPerson(currentFloor.getFromUpQueue());
                //System.out.println(elevators[0].getNumberOfOccupants());
            }
        }
        
        /*
        // Start from top go to bottom
        for (int floor = Config.maxFloor-1; floor <= 0; floor--)
        {
            Floor currentFloor = floors.getFloor(floor);
            
            elevators[0].removePeople(floor);
            
            while (currentFloor.downIsOn() && !elevators[0].isFull())
            {
                elevators[0].addPerson(currentFloor.getFromUpQueue());
            }
        }
        */
    }
}

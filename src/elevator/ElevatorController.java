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
            int floorCount = 0;
            
            for (Floor floor : floorArray)
            {
                elevator.removePeople(floorCount);
                
                while (!floor.getUpQueue().isEmpty())
                {
                    Person personFromUpQueue = floor.getFromUpQueue();

                    elevator.addPerson(personFromUpQueue);
                }
                
                floorCount++;
            }
        }
    }
}
